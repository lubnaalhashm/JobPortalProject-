package com.lubna.job_portal.Repositories;

import com.lubna.job_portal.Models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JobRepository extends JpaRepository<Job, Integer> {
    @Query(value = "SELECT count(j) > 0 from Job j where j.id = :jobId AND j.expiresAt > current_timestamp", nativeQuery = true)
    boolean isJobActive(@Param("jobId") Integer jobId);

}
