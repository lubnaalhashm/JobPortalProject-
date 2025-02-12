package com.lubna.job_portal.DTOs;

import com.lubna.job_portal.Models.Job;
import com.lubna.job_portal.Models.User;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;

@Data
public class JobDTO {
    private Integer recruiterId;
    private Integer id;
    private String title;
    private String description;
    private String location;
    private Double salary;

    // Additional fields

    private Boolean isActive;

    public static JobDTO convertToDTO(Job job) {
        JobDTO jobDto = new JobDTO();
        if (job != null) {
            jobDto.setId(job.getId());
            jobDto.setTitle(job.getTitle());
            jobDto.setDescription(job.getDescription());
            jobDto.setLocation(job.getLocation());
            jobDto.setSalary(job.getSalary());
            jobDto.setIsActive(job.isActive());
        }
        return jobDto;
    }

    public static List<JobDTO> convertToDTO(List<Job> jobList) {
        List<JobDTO> jobDtoList = new ArrayList<>();
        if (jobList != null && !jobList.isEmpty()) {
            for (Job job : jobList) {
                jobDtoList.add(convertToDTO(job));
            }
        }
        return jobDtoList;
    }
    public static Job convertFromDTO(JobDTO jobDto) {
        Job job = new Job();
        if (jobDto != null) {
            job.setId(jobDto.getId());
            job.setTitle(jobDto.getTitle());
            job.setDescription(jobDto.getDescription());
            job.setLocation(jobDto.getLocation());
            job.setSalary(job.getSalary());
            job.setRecruiter(UserDTO.convertFromDTO(jobDto.getRecruiter()));
            job.setJobType(Job.JobType.valueOf(jobDto.getJobType()));
            job.setActive(jobDto.isActive());
        }
        return job;
    }
    public static List<Job> convertFromDTO(List<JobDTO> jobDtoList) {
        List<Job> jobList = new ArrayList<>();
        if (jobDtoList != null && !jobDtoList.isEmpty()) {
            for (JobDTO dto : jobDtoList) {
                jobList.add(convertFromDTO(dto));
            }
        }
        return jobList;
    }
}
