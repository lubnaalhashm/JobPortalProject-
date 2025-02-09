package com.lubna.job_portal.Repositories;

import com.lubna.job_portal.Models.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobSeekerRepository extends JpaRepository<JobSeeker, Integer> {
    //Check if a job Seeker exists by ID
    boolean existsById(Integer id);

    // Find a job Seeker by their associated user ID
    Optional<JobSeeker> findByUserId(Integer userId);
}
