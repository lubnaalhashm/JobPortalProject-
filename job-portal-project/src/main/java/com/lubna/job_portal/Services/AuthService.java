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
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;


    // Sign-in method for JWT generation
    public String signIn(SignInRequestDTO dto) {
        // Find user by username
        User user = userRepository.findByUsername(dto.getUsername())
                .orElseThrow(() -> new InvalidCredentialsException("Invalid username or password"));

        // Check password match
        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException("Invalid username or password");
        }

        // Generate JWT token
        return jwtUtil.generateToken(user.getUsername(), user.getEmail(), user.getRole().name());
    }
    public void signUp(SignUpRequestDTO dto) {
        if (userRepository.findByUsername(dto.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException("Username already exists");
        }
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new UserAlreadyExistsException("Email already exists");
        }

        User newUser = new User();
        newUser.setUsername(dto.getUsername());
        newUser.setEmail(dto.getEmail());
        newUser.setPassword(passwordEncoder.encode(dto.getPassword()));
        newUser.setRole(dto.getRole());

        userRepository.save(newUser);
    }
}