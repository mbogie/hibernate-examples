package com.github.pabloo99.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@NoArgsConstructor
@Data
@Entity
@Table(name = "job_history")
@IdClass(JobHistoryPK.class)
public class JobHistory {

    @Id
    private Integer employeeId;
    @Id
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "job_id")
    private String jobId;

    @Column(name = "department_id")
    private Integer departmentId;
}
