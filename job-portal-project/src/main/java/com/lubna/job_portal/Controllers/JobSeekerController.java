package com.lubna.job_portal.Controllers;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "job-Seeker")
public class JobSeekerController {
    private final Logger logger = LoggerFactory.getLogger(JobSeekerController.class);

}
