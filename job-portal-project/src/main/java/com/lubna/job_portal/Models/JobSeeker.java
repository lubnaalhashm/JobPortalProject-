package com.lubna.job_portal.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "job_seekers")
public class JobSeeker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    private String resumeUrl;
    private String portfolioUrl;
    private String phoneNumber;
    private String address;

    public JobSeeker() {}


    public JobSeeker(User user, String resumeUrl, String portfolioUrl, String phoneNumber, String address) {
        this.user = user;
        this.resumeUrl = resumeUrl;
        this.portfolioUrl = portfolioUrl;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}