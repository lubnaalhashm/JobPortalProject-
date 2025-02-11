package com.lubna.job_portal.Services;

import com.lubna.job_portal.DTOs.JobSeekerDTO;
import com.lubna.job_portal.Models.JobSeeker;
import com.lubna.job_portal.Repositories.JobSeekerRepository;
import com.lubna.job_portal.Utils.HelperUtils;
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
    // Get Job Seeker by ID
   /* public JobSeekerDTO getJobSeekerById(Integer id) {
        JobSeeker entity = jobSeekerRepository.getJobSeekerById(id);
        return JobSeekerDTO.convertToDTO(entity);*/

    public JobSeekerDTO addJobSeeker(JobSeekerDTO jobSeekerDto) {
        if (HelperUtils.isNull(jobSeekerDto.getId()) || !checkIfJobSeekerExists(jobSeekerDto.getId())) {
            JobSeeker jobSeeker = JobSeekerDTO.convertFromDTO(jobSeekerDto);
            jobSeeker = jobSeekerRepository.save(jobSeeker);
            return JobSeekerDTO.convertToDTO(jobSeeker);
        }
        return new JobSeekerDTO();
    }





    public boolean checkIfJobSeekerExists(Integer id) {
        return jobSeekerRepository.existsById(id);
    }
}


