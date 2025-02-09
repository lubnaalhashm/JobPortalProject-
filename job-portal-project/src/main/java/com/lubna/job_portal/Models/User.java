package com.lubna.job_portal.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "users") // Explicitly specify the table name for clarity
public class User extends BaseEntity {

    @NotBlank(message = "Email is mandatory")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING) // Use EnumType.STRING for storing role as a string in the database
    @Column(nullable = false)
    private Role role;

    private String username;
    private boolean isActive = true; // Default active status

    // Enum for user roles

    // Constructors
    public User() {
    }

    public User(String email, String password, Role role, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.username = firstName;

    }
}