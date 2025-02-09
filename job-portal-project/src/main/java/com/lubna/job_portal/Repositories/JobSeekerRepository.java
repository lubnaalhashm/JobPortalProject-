package com.lubna.job_portal.Repositories;

import com.lubna.job_portal.Models.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobSeekerRepository extends JpaRepository<JobApplication, Integer> {
    @Query("SELECT ja from JobApplication ja where ja.jobSeeker.id = :jobSeekerId order by ja.appliedAt DESC")
    List<JobApplication> findByJobSeekerId(@Param("jobSeekerId") Integer jobSeekerId);

    @Query("SELECT ja from JobApplication ja where ja.job.id = :jobId order by ja.appliedAt DESC")
    List<JobApplication> findByJobId(@Param("jobId") Long jobId);
}
