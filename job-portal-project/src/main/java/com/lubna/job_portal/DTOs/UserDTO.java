package com.lubna.job_portal.DTOs;

import com.lubna.job_portal.Models.User;
import lombok.Data;


import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;
import java.util.List;

@Data
public class UserDTO {
    private Integer id;
    private String username;
    private String email;
    private String password;
    private Boolean isActive;


    public static UserDTO convertToDTO(User user) {
        UserDTO userDto = new UserDTO();
        if (user != null) {
            userDto.setId(user.getId());
            userDto.setEmail(user.getEmail());
            userDto.setPassword(user.getPassword());
            userDto.setUsername(user.getUsername());
            userDto.setIsActive(user.getIsActive());
        }
        return userDto;
    }
    public static List<UserDTO> convertToDTO(List<User> userList) {
        List<UserDTO> userDtoList = new ArrayList<>();
        if (userList != null && !userList.isEmpty()) {
            for (User user : userList) {
                userDtoList.add(convertToDTO(user));
            }
        }
        return userDtoList;
    }
    public static User convertFromDTO(UserDTO userDto) {
        User user = new User();
        if (userDto != null)  {
            user.setId(userDto.getId());
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            user.setUsername(userDto.getUsername());
            user.setIsActive(userDto.getIsActive());
        }
        return user;
    }
    public static List<User> convertFromDTO(List<UserDTO> userDtoList) {
        List<User> userList = new ArrayList<>();
        if (userDtoList != null && !userDtoList.isEmpty()) {
            for (UserDTO dto : userDtoList) {
                userList.add(convertFromDTO(dto));
            }
        }
        return userList;
    }
}
