package com.lubna.job_portal.Services;

import com.lubna.job_portal.DTOs.JobSeekerDTO;
import com.lubna.job_portal.Models.JobSeeker;
import com.lubna.job_portal.Repositories.JobSeekerRepository;
import com.lubna.job_portal.Utils.HelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobSeekerService {
    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    public List<JobSeekerDTO> getAllJobSeekers() {
        List<JobSeeker> jobSeekers = jobSeekerRepository.findAll();
        return JobSeekerDTO.convertToDTO(jobSeekers);
    }

    // Get Job Seeker by ID
   public JobSeekerDTO getJobSeekerById(Integer id) {
       JobSeeker entity = jobSeekerRepository.getJobSeekerById(id);
       return JobSeekerDTO.convertToDTO(entity);
   }

}


