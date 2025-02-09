package com.lubna.job_portal.DTOs;

import com.lubna.job_portal.Models.JobSeeker;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class JobSeekerDTO {
    private Integer id;
    private UserDTO user;
    private String email;
    private String resumeUrl;
    private String portfolioUrl;
    private String phoneNumber;
    private String address;

    public static JobSeekerDTO convertToDTO(JobSeeker jobSeeker) {
        JobSeekerDTO jobSeekerDto = new JobSeekerDTO();
        if (jobSeeker != null) {
            jobSeekerDto.setId(jobSeeker.getId());
            jobSeekerDto.setUser(UserDTO.convertToDTO(jobSeeker.getUser())); // Convert nested User entity
            jobSeekerDto.setResumeUrl(jobSeeker.getResumeUrl());
            jobSeekerDto.setPortfolioUrl(jobSeeker.getPortfolioUrl());
            jobSeekerDto.setPhoneNumber(jobSeeker.getPhoneNumber());
            jobSeekerDto.setAddress(jobSeeker.getAddress());
        }
        return jobSeekerDto;
    }
    public static List<JobSeekerDTO> convertToDTO(List<JobSeeker> jobSeekerList) {
        List<JobSeekerDTO> jobSeekerDtoList = new ArrayList<>();
        if (jobSeekerList != null && !jobSeekerList.isEmpty()) {
            for (JobSeeker jobSeeker : jobSeekerList) {
                jobSeekerDtoList.add(convertToDTO(jobSeeker));
            }
        }
        return jobSeekerDtoList;
    }
    public static JobSeeker convertFromDTO(JobSeekerDTO jobSeekerDto) {
        JobSeeker jobSeeker = new JobSeeker();
        if (jobSeekerDto != null) {
            jobSeeker.setId(jobSeekerDto.getId());
            jobSeeker.setUser(UserDTO.convertFromDTO(jobSeekerDto.getUser())); // Convert nested User DTO
            jobSeeker.setResumeUrl(jobSeekerDto.getResumeUrl());
            jobSeeker.setPortfolioUrl(jobSeekerDto.getPortfolioUrl());
            jobSeeker.setPhoneNumber(jobSeekerDto.getPhoneNumber());
            jobSeeker.setAddress(jobSeekerDto.getAddress());
        }
        return jobSeeker;
    }
    public static List<JobSeeker> convertFromDTO(List<JobSeekerDTO> jobSeekerDtoList) {
        List<JobSeeker> jobSeekerList = new ArrayList<>();
        if (jobSeekerDtoList != null && !jobSeekerDtoList.isEmpty()) {
            for (JobSeekerDTO dto : jobSeekerDtoList) {
                jobSeekerList.add(convertFromDTO(dto));
            }
        }
        return jobSeekerList;
    }
}
