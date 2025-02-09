package com.lubna.job_portal.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


import java.util.List;

@Entity
@Data
@Table(name = "jobs")
public class Job extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "recruiter_id", nullable = false)
    private User recruiter; // The user who posted the job

    @NotBlank(message = "Title is mandatory")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "Description is mandatory")
    @Column(nullable = false,  columnDefinition = "TEXT")
    private String description;

    @NotBlank(message = "Location is mandatory")
    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'Remote'")
    private String location;

    @NotNull(message = "Salary cannot be null")
    @Column(nullable = false)
    private Double salary;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private JobType jobType;
    private boolean isActive;


    public enum JobType {
        full_time, part_time, contract, internship
    }

    // Constructors
    public Job() {
    }

    public Job(User recruiter, String title, String description, String location, Double salary, JobType jobType) {
        this.recruiter = recruiter;
        this.title = title;
        this.description = description;
        this.location = location;
        this.salary = salary;
        this.jobType = jobType;
        this.isActive = true; // Default active status
    }
}