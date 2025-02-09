package com.lubna.job_portal.Repositories;

import com.lubna.job_portal.Models.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Integer> {
    @Query("SELECT ja from JobApplication ja where ja.jobSeeker.id = :jobSeekerId order by ja.appliedAt DESC")
    List<JobApplication> findByJobSeekerId(@Param("jobSeekerId") Integer jobSeekerId);

    @Query("SELECT ja from JobApplication ja where ja.job.id = :jobId order by ja.appliedAt DESC")
    List<JobApplication> findByJobId(@Param("jobId") Integer jobId);

    @Query("SELECT count(ja) > 0 from JobApplication ja where ja.job.id = :jobId and ja.jobSeeker.id = :jobSeekerId")
    boolean hasApplied(@Param("jobId") Integer jobId, @Param("jobSeekerId") Integer jobSeekerId);
}
