package com.lubna.job_portal.Services;

import com.lubna.job_portal.DTOs.SignInRequestDTO;
import com.lubna.job_portal.DTOs.SignUpRequestDTO;
import com.lubna.job_portal.Exceptions.InvalidCredentialsException;
import com.lubna.job_portal.Exceptions.UserAlreadyExistsException;
import com.lubna.job_portal.Models.User;
import com.lubna.job_portal.Repositories.UserRepository;
import com.lubna.job_portal.Utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;
    public String signIn(SignInRequestDTO dto) {
        User user = userRepository.findByUsername(dto.getUsername())
                .orElseThrow(() -> new InvalidCredentialsException("Invalid username or password"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException("Invalid username or password");
        }

        // Generate JWT token
        return jwtUtil.generateToken(user.getUsername());
    }
    public void signUp(SignUpRequestDTO dto) {
        if (userRepository.findByUsername(dto.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException("Username already exists");
        }
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new UserAlreadyExistsException("Email already exists");
        }

        // Proceed with user creation logic
    }
}