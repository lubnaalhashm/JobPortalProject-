package com.lubna.job_portal.Controllers;

import com.lubna.job_portal.DTOs.JobSeekerDTO;
import com.lubna.job_portal.Services.JobSeekerService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
