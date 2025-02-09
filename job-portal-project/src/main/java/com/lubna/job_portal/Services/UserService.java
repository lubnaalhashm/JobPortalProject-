package com.lubna.job_portal.Services;

import com.lubna.job_portal.DTOs.UserDTO;
import com.lubna.job_portal.Models.User;
import com.lubna.job_portal.Repositories.UserRepository;
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
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.map(UserDTO::convertToDTO).orElse(new UserDTO());
    }
    public UserDTO addUser(UserDTO dto) {
        if (dto == null || dto.getEmail() == null || dto.getPassword() == null) {
            return new UserDTO();
        }
        if (userRepository.existsByEmail(dto.getEmail())) {
            return new UserDTO();
        }
        User entity = new User();
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setUsername(dto.getUsername());
        User savedUser = userRepository.save(entity);
        return UserDTO.convertToDTO(savedUser);
    }
}

