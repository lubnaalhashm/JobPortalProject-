package com.lubna.job_portal.Repositories;

import com.lubna.job_portal.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByEmail(String email);

    @Query("SELECT u from User u where u.email = :email and u.isActive = true")
    Optional<User> findActiveUserByEmail(@Param("email") String email);

    @Query("SELECT count(u) > 0 from User u where u.email = :email and u.isActive = true")
    boolean existsByEmail(@Param("email") String email);

}
