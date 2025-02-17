package com.lubna.job_portal.Controllers;


import com.lubna.job_portal.DTOs.JobApplicationDTO;
import com.lubna.job_portal.Enum.JobType;
import com.lubna.job_portal.Services.JobApplicationsService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "jobApplication")
public class JobApplicationController {

    private final Logger logger = LoggerFactory.getLogger(JobApplicationController.class);
  
}
