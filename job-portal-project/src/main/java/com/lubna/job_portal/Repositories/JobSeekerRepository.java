package com.lubna.job_portal.Repositories;

import com.lubna.job_portal.Models.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobSeekerRepository extends JpaRepository<JobSeeker, Integer> {
    boolean existsById(Integer id);
    JobSeeker getJobSeekerById(Integer id);

    // Find a job Seeker by their associated user ID
    Optional<JobSeeker> findByUserId(Integer userId);

    // Write query to find job Seekers by phone number
    @Query("SELECT js from JobSeeker js where js.phoneNumber = :phoneNumber")
    Optional<JobSeeker> findByPhoneNumber(String phoneNumber);

    // Write query to find jobSeekers by email
    @Query("SELECT js from JobSeeker js where js.user.email = :email")
    Optional<JobSeeker> findByUserEmail(String email);
}
