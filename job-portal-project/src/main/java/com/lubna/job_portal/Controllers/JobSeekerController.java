package com.lubna.job_portal.Controllers;

import com.lubna.job_portal.DTOs.JobSeekerDTO;
import com.lubna.job_portal.Models.JobSeeker;
import com.lubna.job_portal.Repositories.JobSeekerRepository;
import com.lubna.job_portal.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerController {

    @Autowired
    private JobSeekerRepository jobSeekerRepository;
    @Autowired
    private UserRepository userRepository;

    public List<JobSeekerDTO> getAllJobSeekers() {
        List<JobSeeker> jobSeekers = jobSeekerRepository.findAll();
        return JobSeekerDTO.convertToDTO(jobSeekers);
    }


}
