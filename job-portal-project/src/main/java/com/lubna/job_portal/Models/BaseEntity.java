package com.lubna.job_portal.Models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;


import java.time.LocalDateTime;

    @MappedSuperclass
    public abstract class BaseEntity {
    }
