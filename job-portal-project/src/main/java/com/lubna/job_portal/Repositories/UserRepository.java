package com.lubna.job_portal.Repositories;

import com.lubna.job_portal.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer>{
    @Query("SELECT u from User u where u.email = :email and u.isActive = true")
    Optional<User> findByEmail(@Param("email") String email);

    @Query("SELECT count(u) > 0 from User u where u.email = :email and u.isActive = true")
    boolean existsByEmail(@Param("email") String email);

}
