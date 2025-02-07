package com.lubna.job_portal.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "job_seekers")
public class JobSeeker extends BaseEntity{
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "id", nullable = false )
    private User user;
    private String resumeUrl;
    private String portfolioUrl;
    private String phone;
    private String address;
}
