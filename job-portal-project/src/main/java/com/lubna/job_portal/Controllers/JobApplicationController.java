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
    @Autowired
    private JobApplicationsService jobApplicationsService;

    @GetMapping(value = "getAll")
    public List<JobApplicationDTO> getAllApplications() {
        List<JobApplicationDTO> jobApplicationDTOList = new ArrayList<>();
        try {
            jobApplicationDTOList.addAll(jobApplicationsService.fetchAllApplications());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return jobApplicationDTOList;
    }

    @GetMapping(value = "getById")
    public JobApplicationDTO getApplicationById(@RequestParam(value = "applicationId") Integer id) {
        try {
            return jobApplicationsService.getApplicationById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new JobApplicationDTO();
        }
    }

    @PostMapping(value = "add")
    public JobApplicationDTO addApplication(@RequestBody JobApplicationDTO dto) {
        JobApplicationDTO jobApplicationDTO = new JobApplicationDTO();
        try {
            jobApplicationDTO = jobApplicationsService.addApplication(dto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return jobApplicationDTO;
    }

    @PostMapping(value = "update")
    public JobApplicationDTO updateApplication(@RequestBody JobApplicationDTO dto) {
        JobApplicationDTO jobApplicationDTO = new JobApplicationDTO();
        try {
            jobApplicationDTO = jobApplicationsService.updateApplication(dto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return jobApplicationDTO;
    }

    @DeleteMapping(value = "delete")
    public Boolean deleteApplication(@RequestBody JobApplicationDTO dto) {
        try {
            return jobApplicationsService.deleteApplication(dto.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @GetMapping(value = "checkApplicationAvailability")
    public Boolean checkApplicationAvailability(@RequestParam Integer jobSeekerId, @RequestParam Integer jobId) {
        try {
            return jobApplicationsService.checkApplicationBySeekerAndJob(jobSeekerId, jobId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


}
