package com.lubna.job_portal.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(value = "jobs")
public class JobController {

    private final Logger logger = LoggerFactory.getLogger(JobController.class);

}
