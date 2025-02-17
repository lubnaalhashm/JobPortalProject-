package com.lubna.job_portal.Models;

import com.lubna.job_portal.Enum.ApplicationStatus;
import com.lubna.job_portal.Enum.JobType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "job_applications")
public class JobApplication extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "job_seeker_id", nullable = false)
    private JobSeeker applicant;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String coverLetter;

    @Enumerated(EnumType.STRING)
    @Column
    private ApplicationStatus status;

    @Enumerated(EnumType.STRING)
    @Column
    private JobType jobType;
    @Column
    private LocalDateTime appliedAt;

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
