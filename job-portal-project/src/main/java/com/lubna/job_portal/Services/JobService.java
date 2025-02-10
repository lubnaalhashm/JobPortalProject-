package com.lubna.job_portal.Services;

import com.lubna.job_portal.DTOs.JobDTO;
import com.lubna.job_portal.Models.Job;
import com.lubna.job_portal.Repositories.JobRepository;
import com.lubna.job_portal.Utils.HelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<JobDTO> getAllJobs() {
        List<Job> jobs = jobRepository.findAll();
        return JobDTO.convertToDTO(jobs);
    }

    public JobDTO getJobById(Integer id) {
        Job job = jobRepository.findById(id).orElse(null);
        return JobDTO.convertToDTO(job);
    }
    public JobDTO addJob(JobDTO jobDto) {
        if (HelperUtils.isNull(jobDto.getId()) || !checkIfJobExists(jobDto.getId())) {
            Job job = JobDTO.convertFromDTO(jobDto);
            job = jobRepository.save(job);
            return JobDTO.convertToDTO(job);
        }
        return new JobDTO();
    }

    public boolean checkIfJobExists(Integer id) {
        return jobRepository.existsById(id);
    }

}
