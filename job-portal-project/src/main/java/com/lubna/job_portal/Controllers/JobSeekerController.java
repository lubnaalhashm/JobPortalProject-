package com.lubna.job_portal.Controllers;

import com.lubna.job_portal.DTOs.JobSeekerDTO;
import com.lubna.job_portal.Services.JobSeekerService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "job-Seeker")
public class JobSeekerController {
    private final Logger logger = LoggerFactory.getLogger(JobSeekerController.class);

    @Autowired
    private JobSeekerService jobSeekerService;

    @GetMapping(value = "getAll")
    public List<JobSeekerDTO> getAllJobSeekers() {
        List<JobSeekerDTO> jobSeekerDTOList = new ArrayList<>();
        try {
            jobSeekerDTOList.addAll(jobSeekerService.getAllJobSeekers());
        } catch (Exception e) {
            logger.error("Error while fetching all job seekers: {}", e.getMessage());
        }
        return jobSeekerDTOList;
    }
    @GetMapping(value = "getById")
    public JobSeekerDTO getJobSeekerById(@RequestParam(value = "jobSeekerId") Integer id) {
        try {
            return jobSeekerService.getJobSeekerById(id);
        } catch (Exception e) {
            logger.error("Error while fetching job seeker by ID: {}", e.getMessage());
            return new JobSeekerDTO();
        }
    }
    @PostMapping(value = "add")
    public JobSeekerDTO addJobSeeker(@RequestBody JobSeekerDTO dto) {
        try {
            return jobSeekerService.addJobSeeker(dto);
        } catch (Exception e) {
            logger.error("Error while adding job seeker: {}", e.getMessage());
            return new JobSeekerDTO();
        }
    }


    @PostMapping(value = "update")
    public JobSeekerDTO updateJobSeeker(@RequestBody JobSeekerDTO dto) {
        try {
            return jobSeekerService.updateJobSeeker(dto);
        } catch (Exception e) {
            logger.error("Error while updating job seeker: {}", e.getMessage());
            return new JobSeekerDTO();
        }
    }


    @DeleteMapping(value = "delete")
    public Boolean deleteJobSeeker(@RequestBody JobSeekerDTO dto) {
        try {
            return jobSeekerService.deleteJobSeeker(dto.getId());
        } catch (Exception e) {
            logger.error("Error while deleting job seeker: {}", e.getMessage());
            System.out.println(e.getMessage());
            return false;
        }
    }
    @GetMapping(value = "checkJobSeekerExists")
    public Boolean checkIfJobSeekerExists(@RequestParam Integer jobSeekerId) {
        try {
            return jobSeekerService.checkIfJobSeekerExists(jobSeekerId);
        } catch (Exception e) {
            logger.error("Error while checking if job seeker exists: {}", e.getMessage());
            return false;
        }
    }
    @GetMapping(value = "getByEmail")
    public JobSeekerDTO getJobSeekerByEmail(@RequestParam String email) {
        try {
            return jobSeekerService.getJobSeekerByEmail(email);
        } catch (Exception e) {
            logger.error("Error while fetching job seeker by email: {}", e.getMessage());
            return new JobSeekerDTO();
        }
    }
    @GetMapping(value = "getByUserId")
    public JobSeekerDTO getJobSeekerByUserId(@RequestParam(value = "userId") Integer userId) {
        try {
            return jobSeekerService.getJobSeekerByUserId(userId);
        } catch (Exception e) {
            logger.error("Error while fetching job seeker by user ID: {}", e.getMessage());
            return new JobSeekerDTO();
        }
    }

}
