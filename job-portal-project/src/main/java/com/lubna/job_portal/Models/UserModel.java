package com.lubna.job_portal.Models;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data

public class UserModel extends BaseEntity {
    private String userName;
    private String password;
    private String role; // admin or Employee
}