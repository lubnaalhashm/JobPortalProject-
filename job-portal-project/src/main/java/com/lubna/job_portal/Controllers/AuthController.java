package com.lubna.job_portal.Controllers;

import com.lubna.job_portal.DTOs.SignInRequestDTO;
import com.lubna.job_portal.DTOs.SignUpRequestDTO;
import com.lubna.job_portal.Services.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")

public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignUpRequestDTO dto) {
        authService.signUp(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("message", "User registered successfully"));
    }

    // SignIn Endpoint
    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@Valid @RequestBody SignInRequestDTO dto) {
        String token = authService.signIn(dto);
        return ResponseEntity.ok(Map.of("token", token));  // Return the token in response
    }

}
