package com.lubna.job_portal.Models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;


import java.time.LocalDateTime;

    @MappedSuperclass
    public abstract class BaseEntity {
        @Column(name = "created_at", updatable = false)
        private LocalDateTime createdAt;

        @Column(name = "updated_at")
        private LocalDateTime updatedAt;

        @PrePersist
        protected void onCreate() {
            this.createdAt = LocalDateTime.now();
        }
    }
