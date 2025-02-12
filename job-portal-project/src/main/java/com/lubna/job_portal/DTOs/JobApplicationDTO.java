package com.lubna.job_portal.DTOs;

import com.lubna.job_portal.Models.ApplicationStatus;
import com.lubna.job_portal.Models.Job;
import com.lubna.job_portal.Models.JobApplication;
import com.lubna.job_portal.Models.JobSeeker;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class JobApplicationDTO {
    private Integer id;
    private Integer jobId;
    private Integer jobSeekerId;
    private String status;
    private String coverLetter;
    private LocalDateTime appliedAt;

    public static JobApplicationDTO convertToDTO(JobApplication jobApplication) {
        JobApplicationDTO dto = new JobApplicationDTO();
        if (jobApplication != null) {
            dto.setId(jobApplication.getId());
            dto.setJobId(jobApplication.getJob() != null ? jobApplication.getJob().getId() : null); // Extract Job ID
            dto.setJobSeekerId(jobApplication.getApplicant() != null ? jobApplication.getApplicant().getId() : null); // Extract JobSeeker ID
            dto.setStatus(jobApplication.getStatus() != null ? jobApplication.getStatus().name() : null); // Convert Enum to String
            dto.setCoverLetter(jobApplication.getCoverLetter());
            dto.setAppliedAt(jobApplication.getAppliedAt());
        }
        return dto;
    }
    public static List<JobApplicationDTO> convertToDTO(List<JobApplication> jobApplicationList) {
        List<JobApplicationDTO> dtoList = new ArrayList<>();
        if (jobApplicationList != null && !jobApplicationList.isEmpty()) {
            for (JobApplication jobApplication : jobApplicationList) {
                dtoList.add(convertToDTO(jobApplication));
            }
        }
        return dtoList;
    }
    public static JobApplication convertFromDTO(JobApplicationDTO dto) {
        JobApplication jobApplication = new JobApplication();
        if (dto != null) {
            jobApplication.setId(dto.getId());

            Job job = new Job();
            job.setId(dto.getJobId());
            jobApplication.setJob(job);

            JobSeeker jobSeeker = new JobSeeker();
            jobSeeker.setId(dto.getJobSeekerId());

            jobApplication.setCoverLetter(dto.getCoverLetter());
            jobApplication.setStatus(dto.getStatus() != null ? ApplicationStatus.valueOf(dto.getStatus()) : null); // Convert String to Enum
            jobApplication.setAppliedAt(dto.getAppliedAt());
        }
        return jobApplication;
    }
    public static List<JobApplication> convertFromDTO(List<JobApplicationDTO> dtoList) {
        List<JobApplication> jobApplicationList = new ArrayList<>();
        if (dtoList != null && !dtoList.isEmpty()) {
            for (JobApplicationDTO dto : dtoList) {
                jobApplicationList.add(convertFromDTO(dto));
            }
        }
        return jobApplicationList;
    }
}
