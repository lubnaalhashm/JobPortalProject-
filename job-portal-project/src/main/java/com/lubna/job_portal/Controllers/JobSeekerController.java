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
        JobSeekerDTO jobSeekerDTO = new JobSeekerDTO();
        try {
            jobSeekerDTO = jobSeekerService.addJobSeeker(dto);
        } catch (Exception e) {
            logger.error("Error while adding job seeker: {}", e.getMessage());
            System.out.println(e.getMessage());
        }
        return jobSeekerDTO;
    }

    @PostMapping(value = "update")
    public JobSeekerDTO updateJobSeeker(@RequestBody JobSeekerDTO dto) {
        JobSeekerDTO jobSeekerDTO = new JobSeekerDTO();
        try {
            jobSeekerDTO = jobSeekerService.updateJobSeeker(dto);
        } catch (Exception e) {
            logger.error("Error while updating job seeker: {}", e.getMessage());
            System.out.println(e.getMessage());
        }
        return jobSeekerDTO;
    }
    
}
