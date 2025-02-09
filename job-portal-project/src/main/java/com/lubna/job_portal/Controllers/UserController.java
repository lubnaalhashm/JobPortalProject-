package com.lubna.job_portal.Controllers;


import com.lubna.job_portal.DTOs.UserDTO;
import com.lubna.job_portal.Services.UserService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping(value = "getAll")
    public List<UserDTO> getAllUsers() {
        List<UserDTO> userDTOList = new ArrayList<>();
        try {
            userDTOList.addAll(userService.getAllUser());
        } catch (Exception e) {
            logger.error("Error while fetching all users: {}", e.getMessage());
        }
        return userDTOList;
    }

    @GetMapping(value = "getById")
    public UserDTO getUserById(@RequestParam(value = "userId") Integer id) {
        try {
            return userService.getUserById(id);
        } catch (Exception e) {
            logger.error("Error while fetching user by ID: {}", e.getMessage());
            return new UserDTO();
        }
    }
    @PostMapping(value = "add")
    public UserDTO addUser(@RequestBody UserDTO dto) {
        UserDTO userDTO = new UserDTO();
        try {
            userDTO = userService.addUser(dto);
        } catch (Exception e) {
            logger.error("Error while adding user: {}", e.getMessage(), e); // Log the full stack trace
            System.out.println(e.getMessage());
        }
        return userDTO;
    }
    @PostMapping(value = "update")
    public UserDTO updateUser(@RequestBody UserDTO dto) {
        UserDTO userDTO = new UserDTO();
        try {
            userDTO = userService.updateUser(dto);
        } catch (Exception e) {
            logger.error("Error while updating user: {}", e.getMessage());
            System.out.println(e.getMessage());
        }
        return userDTO;
    }
    @DeleteMapping(value = "delete")
    public Boolean deleteUser(@RequestBody UserDTO dto) {
        try {
            return userService.deleteUser(dto.getId());
        } catch (Exception e) {
            logger.error("Error while deleting user: {}", e.getMessage());
            System.out.println(e.getMessage());
            return false;
        }
    }
    @GetMapping(value = "checkUserExists")
    public Boolean checkIfUserExistsByEmail(@RequestParam String email) {
        try {
            return userService.checkIfUserExistsByEmail(email);
        } catch (Exception e) {
            logger.error("Error while checking user existence: {}", e.getMessage());
            System.out.println(e.getMessage());
            return false;
        }
    }
    @GetMapping(value = "getByEmail")
    public UserDTO getUserByEmail(@RequestParam String email) {
        try {
            return userService.getUserByEmail(email);
        } catch (Exception e) {
            logger.error("Error while fetching user by email: {}", e.getMessage());
            return new UserDTO();
        }
    }
    @PostMapping(value = "changeActiveStatus")
    public Boolean changeUserActiveStatus(@RequestBody UserDTO dto) {
        try {
            return userService.changeUserActiveStatus(dto.getId(), dto.getIsActive());
        } catch (Exception e) {
            logger.error("Error while changing user active status: {}", e.getMessage());
            System.out.println(e.getMessage());
            return false;
        }
    }
}
