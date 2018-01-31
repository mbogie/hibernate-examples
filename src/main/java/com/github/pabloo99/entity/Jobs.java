package com.github.pabloo99.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Data
@Entity
@Table(name = "jobs")
public class Jobs {

    @Id
    @Column(name = "job_id")
    private String id;

    @Column(name = "job_title")
    private String name;

    @Column(name = "min_salary")
    private Integer minSalary;

    @Column(name = "max_salary")
    private Integer maxSalary;
}
