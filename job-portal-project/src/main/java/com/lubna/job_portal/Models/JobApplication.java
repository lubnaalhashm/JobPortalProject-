package com.lubna.job_portal.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "job_applications")
public class JobApplication extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "job_seeker_id", nullable = false)
    private JobSeeker jobSeeker;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String coverLetter;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status; 

    private LocalDateTime appliedAt;

    // Enum for application status
    public enum ApplicationStatus {
        PENDING, ACCEPTED, REJECTED
    }

    // Constructors
    public JobApplication() {
    }

    public JobApplication(JobSeeker jobSeeker, Job job, String coverLetter) {
        this.jobSeeker = jobSeeker;
        this.job = job;
        this.coverLetter = coverLetter;
        this.status = ApplicationStatus.PENDING;
        this.appliedAt = LocalDateTime.now();
    }
}
