package com.lubna.job_portal.Services;

import com.lubna.job_portal.DTOs.JobDTO;
import com.lubna.job_portal.Models.Job;
import com.lubna.job_portal.Repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<JobDTO>getAllJobs(){
        List<Job> jobs = jobRepository.findAll();
        return JobDTO.convertToDTO(jobs);
    }
    
}
