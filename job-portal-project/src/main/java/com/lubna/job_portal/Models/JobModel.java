package com.lubna.job_portal.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Entity
@Data
@Table(name = "job")
public class JobModel extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Title is mandatory")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "Description is mandatory")
    @Column(nullable = false)
    private String description;

    @NotBlank(message = "Location is mandatory ")
    @Column(nullable = false, columnDefinition = "Varchar(255) defualt 'Remote'")
    private String location;

    @NotBlank(message = "Salary must be positive")
    @NotNull(message = "Salary cannot be null")
    @Column(nullable = false)
    private Double salary;

}

