package com.lubna.job_portal.Controllers;

import com.lubna.job_portal.Services.JobSeekerService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "job-Seeker")
public class JobSeekerController {
    private final Logger logger = LoggerFactory.getLogger(JobSeekerController.class);

    @Autowired
    private JobSeekerService jobSeekerService;

}
