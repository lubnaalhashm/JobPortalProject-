package com.lubna.job_portal.Repositories;

import com.lubna.job_portal.Models.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSeekerRepository extends JpaRepository<JobSeeker, Integer> {
    
}
