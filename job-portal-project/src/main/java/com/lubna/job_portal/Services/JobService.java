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

    public JobDTO updateJob(JobDTO jobDto) {
        if (HelperUtils.isNotNull(jobDto)) {
            Job job = JobDTO.convertFromDTO(jobDto);
            job = jobRepository.save(job);
            return JobDTO.convertToDTO(job);
        }
        return new JobDTO();
    }

    public Boolean deleteJob(Integer id) {
        if (HelperUtils.isNotNull(id) && checkIfJobExists(id)) {
            Job job = jobRepository.findById(id).orElse(null);
            if (job != null && job.isActive()) {
                job.setActive(false); // Soft delete
                jobRepository.save(job);
                return true;
            }
        }
        return false;
    }

    public boolean checkIfJobExists(Integer id) {
        return jobRepository.existsById(id);
    }

    public List<JobDTO> getActiveJobs() {
        List<Job> activeJobs = jobRepository.findByIsActiveTrue();
        return JobDTO.convertToDTO(activeJobs);
    }
    public Boolean checkIfJobExistsByTitle(String title) {
        try {
            return jobRepository.existsByTitle(title);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
