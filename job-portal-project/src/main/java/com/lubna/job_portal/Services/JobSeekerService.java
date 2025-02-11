package com.lubna.job_portal.Services;

import com.lubna.job_portal.DTOs.JobSeekerDTO;
import com.lubna.job_portal.Models.JobSeeker;
import com.lubna.job_portal.Repositories.JobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerService {
    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    public List<JobSeekerDTO> getAllJobSeekers() {
        List<JobSeeker> jobSeekers = jobSeekerRepository.findAll();
        return JobSeekerDTO.convertToDTO(jobSeekers);
    }
}
