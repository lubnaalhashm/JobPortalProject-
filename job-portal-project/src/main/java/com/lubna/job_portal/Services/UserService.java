package com.lubna.job_portal.Services;

import com.lubna.job_portal.DTOs.UserDTO;
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
    public UserDTO updateUser(UserDTO dto) {
        if (dto == null || dto.getId() == null) {
            return new UserDTO();
        }
        Optional<User> optionalUser = userRepository.findById(dto.getId());
        if (optionalUser.isEmpty()) {
            return new UserDTO();
        }
        User entity = optionalUser.get();
        if (dto.getEmail() != null && !dto.getEmail().isEmpty()) {
            entity.setEmail(dto.getEmail());
        }
        if (dto.getPassword() != null && !dto.getPassword().isEmpty()) {
            entity.setPassword(dto.getPassword());
        }
        if (dto.getUsername() != null && !dto.getUsername().isEmpty()) {
            entity.setUsername(dto.getUsername());
        }
        User updatedUser = userRepository.save(entity);
        return UserDTO.convertToDTO(updatedUser);
    }
    public Boolean deleteUser(Integer id) {
        if (id == null) {
            return false;
        }
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            return false;
        }
        User user = optionalUser.get();
        user.setActive(false);
        userRepository.save(user);
        return true;
    }

    public UserDTO getUserByEmail(String email) {
        if (email == null || email.isEmpty()) {
            return new UserDTO();
        }
        Optional<User> optionalUser = userRepository.findByEmail(email);
        return optionalUser.map(UserDTO::convertToDTO).orElse(new UserDTO());
    }
    public Boolean changeUserActiveStatus(Integer id, boolean isActive) {
        if (id == null) {
            return false;
        }
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            return false;
        }
        User user = optionalUser.get();
        user.setActive(isActive);
        userRepository.save(user);
        return true;
    }
}

