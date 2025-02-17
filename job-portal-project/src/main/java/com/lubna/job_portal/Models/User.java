package com.lubna.job_portal.Models;

import com.lubna.job_portal.Enum.Role;
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

   /* @Enumerated(EnumType.STRING) // Use EnumType.STRING for storing role as a string in the database
    @Column(nullable = false)
    private Role role;

    private String username;
    private Boolean isActive = true; // Default active status

    // Enum for user roles

    // Constructors
    public User() {
        this.isActive = true;
    }

    public User(String email, String password, Role role, String firstName) {
        this.username = firstName;
        this.email = email;
        this.password = password;
       // this.role = role;

    }
}