package com.lubna.job_portal.Repositories;

import com.lubna.job_portal.Models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Integer> {
    boolean existsByTitle(String title);

    @Query(value = "SELECT count(j) > 0 from Job j where j.id = :jobId AND j.expiresAt > current_timestamp", nativeQuery = true)
    boolean isJobActive(@Param("jobId") Integer jobId);

    // check if a job exists by ID
    boolean existsById(Integer id);

    // query to find active jobs
    @Query("SELECT j from Job j where j.isActive = true")
    List<Job> findByIsActiveTrue();
}
