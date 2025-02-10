package com.lubna.job_portal.Controllers;

import com.lubna.job_portal.DTOs.JobDTO;
import com.lubna.job_portal.Services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping(value = "getAll")
    public List<JobDTO> getAllJobs() {
        List<JobDTO> jobDtoList = new ArrayList<>();
        try {
            jobDtoList.addAll(jobService.getAllJobs());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return jobDtoList;
    }

}
