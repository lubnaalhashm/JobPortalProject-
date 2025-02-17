package com.lubna.job_portal.Services;

import com.lubna.job_portal.DTOs.JobSeekerDTO;
import com.lubna.job_portal.Models.JobSeeker;
import com.lubna.job_portal.Models.User;
import com.lubna.job_portal.Repositories.JobSeekerRepository;
import com.lubna.job_portal.Repositories.UserRepository;
import com.lubna.job_portal.Utils.HelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

import static com.lubna.job_portal.DTOs.JobSeekerDTO.convertToDTO;
@Service
public class JobSeekerService {
    private static final Logger logger = LoggerFactory.getLogger(JobSeekerService.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    public List<JobSeekerDTO> getAllJobSeekers() {
        List<JobSeeker> jobSeekers = jobSeekerRepository.findAll();
        return convertToDTO(jobSeekers);
    }

    // Get Job Seeker by ID
    public JobSeekerDTO getJobSeekerById(Integer id) {
        JobSeeker entity = jobSeekerRepository.getJobSeekerById(id);
        return convertToDTO(entity);
    }


    public JobSeekerDTO addJobSeeker(JobSeekerDTO dto) {
        try {
            if (dto.getUser() == null || dto.getUser().getId() == null) {
                throw new RuntimeException("User ID is required to create a Job Seeker");
            }

            User user = userRepository.findById(dto.getUser().getId())  // FIXED: Correctly retrieve User ID
                    .orElseThrow(() -> new RuntimeException("User not found with ID: " + dto.getUser().getId()));

            JobSeeker jobSeeker = new JobSeeker(user, dto.getResumeUrl(), dto.getPortfolioUrl(), dto.getPhoneNumber(), dto.getAddress());
            jobSeeker = jobSeekerRepository.save(jobSeeker);
            return JobSeekerDTO.convertToDTO(jobSeeker);
        }
        return new JobSeekerDTO();
    }

    public JobSeekerDTO updateJobSeeker(JobSeekerDTO jobSeekerDto) {
        if (HelperUtils.isNotNull(jobSeekerDto)) {
            JobSeeker jobSeeker = JobSeekerDTO.convertFromDTO(jobSeekerDto);
            jobSeeker = jobSeekerRepository.save(jobSeeker);
            return JobSeekerDTO.convertToDTO(jobSeeker);
        }
        return new JobSeekerDTO();
    }
    public Boolean deleteJobSeeker(Integer id) {
        if (HelperUtils.isNotNull(id) && checkIfJobSeekerExists(id)) {
            JobSeeker jobSeeker = jobSeekerRepository.findById(id).orElse(null);
            if (jobSeeker != null) {
                jobSeekerRepository.delete(jobSeeker);
                return true;
            }
        }
        return false;
    }

    public JobSeekerDTO getJobSeekerByUserId(Integer userId) {
        if (HelperUtils.isNotNull(userId)) {
            Optional<JobSeeker> jobSeekerOptional = jobSeekerRepository.findByUserId(userId);
            if (jobSeekerOptional.isPresent()) {
                return JobSeekerDTO.convertToDTO(jobSeekerOptional.get());
            }
        }
        return new JobSeekerDTO();
    }

    public JobSeekerDTO getJobSeekerByEmail(String email) {
        if (HelperUtils.isNotNull(email)) {
            Optional<JobSeeker> jobSeekerOptional = jobSeekerRepository.findByUserEmail(email);
            if (jobSeekerOptional.isPresent()) {
                return JobSeekerDTO.convertToDTO(jobSeekerOptional.get());
            }
        }
        return new JobSeekerDTO();
    }

    public boolean checkIfJobSeekerExists(Integer id) {
        return jobSeekerRepository.existsById(id);
    }
}


