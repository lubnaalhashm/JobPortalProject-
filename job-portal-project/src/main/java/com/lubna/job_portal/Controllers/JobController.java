package com.lubna.job_portal.Controllers;

import com.lubna.job_portal.DTOs.JobDTO;
import com.lubna.job_portal.Services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "jobs")
public class JobController {

    private final Logger logger = LoggerFactory.getLogger(JobController.class);
    @Autowired
    private JobService jobService;

    @GetMapping(value = "getAllJob")
    public List<JobDTO> getAllJobs() {
        List<JobDTO> jobDtoList = new ArrayList<>();
        try {
            jobDtoList.addAll(jobService.getAllJobs());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return jobDtoList;
    }

    @GetMapping(value = "getById")

    public JobDTO getJobById(@RequestParam(value = "jobId") Integer id) {
        try {
            return jobService.getJobById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @PostMapping(value = "addJob")
    public JobDTO addJob(@RequestBody JobDTO dto) {
        logger.info("Received request to add job: {}", dto);
        JobDTO entity = new JobDTO();
        try {
            entity = jobService.addJob(dto);
            logger.info("Job saved: {}", entity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return entity;

    }
    @PostMapping(value = "update")
    public JobDTO updateJob(@RequestBody JobDTO dto) {
        JobDTO entity = new JobDTO();
        try {
            entity = jobService.updateJob(dto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return entity;
    }

    @DeleteMapping(value = "deleteJob")
    public Boolean deleteJob(@RequestBody JobDTO dto) {
        try {
            return jobService.deleteJob(dto.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    @GetMapping(value = "checkJobAvailability")
    public Boolean checkJobAvailability(@RequestParam String title) {
        try {
            return jobService.checkIfJobExistsByTitle(title);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    @GetMapping(value = "getActiveJobs")
    public List<JobDTO> getActiveJobs() {
        List<JobDTO> jobDtoList = new ArrayList<>();
        try {
            jobDtoList.addAll(jobService.getActiveJobs());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return jobDtoList;
    }
}
