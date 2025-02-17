package com.lubna.job_portal.Services;

import com.lubna.job_portal.DTOs.UserDTO;
import com.lubna.job_portal.Enum.Role;
import com.lubna.job_portal.Models.User;
import com.lubna.job_portal.Repositories.UserRepository;
import com.lubna.job_portal.Utils.HelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //Get all users
    public List<UserDTO> getAllUser() {
        List<User> users = userRepository.findAll();
        return UserDTO.convertToDTO(users);
    }

    public UserDTO getUserById(Integer id) {
        if (HelperUtils.isNull(id)) {
            return new UserDTO();
        }
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.map(UserDTO::convertToDTO).orElse(new UserDTO());
    }

    public UserDTO addUser(UserDTO dto) {
        if (HelperUtils.isNull(dto) || HelperUtils.isNull(dto.getEmail()) || HelperUtils.isNull(dto.getPassword())) {
            return new UserDTO();
        }
        if (userRepository.existsByEmail(dto.getEmail())) {
            return new UserDTO();
        }
        User entity = new User();
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setUsername(dto.getUsername());
        entity.setRole(dto.getRole() != null ? Role.valueOf(dto.getRole()) : Role.JOB_SEEKER);
        User savedUser = userRepository.save(entity);
        return UserDTO.convertToDTO(savedUser);
    }
    public Boolean changeUserRole(Integer id, String newRole) {

    public UserDTO updateUser(UserDTO dto) {
        if (HelperUtils.isNull(dto) || HelperUtils.isNull(dto.getId())) {
            return new UserDTO();
        }
        Optional<User> optionalUser = userRepository.findById(dto.getId());
        if (optionalUser.isEmpty()) {
            return new UserDTO();
        }
        User entity = optionalUser.get();
        entity.setEmail(HelperUtils.checkEquals(entity.getEmail(), dto.getEmail()));
        entity.setPassword(HelperUtils.checkEquals(entity.getPassword(), dto.getPassword()));
        entity.setUsername(HelperUtils.checkEquals(entity.getUsername(), dto.getUsername()));
        User updatedUser = userRepository.save(entity);
        return UserDTO.convertToDTO(updatedUser);
    }

    public Boolean deleteUser(Integer id) {
        if (HelperUtils.isNull(id)) {
            return false;
        }
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            return false;
        }
        User user = optionalUser.get();
        user.setIsActive(false);
        userRepository.delete(user);
        return true;
    }

    public Boolean checkIfUserExistsByEmail(String email) {
        System.out.println("Email: " + email);
        if (HelperUtils.isNull(email)) {
            return false;
        }
        return userRepository.existsByEmail(email);
    }

    public UserDTO getUserByEmail(String email) {
        if (HelperUtils.isNull(email)) {
            return new UserDTO();
        }
        Optional<User> optionalUser = userRepository.findByEmail(email);
        return optionalUser.map(UserDTO::convertToDTO).orElse(new UserDTO());
    }

    public Boolean changeUserActiveStatus(Integer id, boolean isActive) {
        if (HelperUtils.isNull(id)) {
            return false;
        }
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            return false;
        }
        User user = optionalUser.get();
        user.setIsActive(isActive);
        userRepository.save(user);
        return true;
    }

}


