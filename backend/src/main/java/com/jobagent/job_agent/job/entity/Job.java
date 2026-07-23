package com.jobagent.job_agent.job.entity;

import com.jobagent.job_agent.common.entity.BaseEntity;
import com.jobagent.job_agent.company.entity.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "jobs", uniqueConstraints = {@UniqueConstraint(columnNames = {"company_id","job_page_url"})})
public class Job extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @Column(nullable = false, length = 250)
    private String title;

    @Column(name = "job_page_url", nullable = false, length = 1000)
    private String jobPageUrl;

    @Column(name = "apply_url", length = 1000)
    private String applyUrl;

    @Column(length = 150)
    private String location;

    @Column(name = "employment_type", length = 100)
    private String employmentType;

    @Column(length = 100)
    private String experience;

    private String description;

    private LocalDate postedDate;

    private String department;

    @Column(length = 100)
    private String jobType;

    @Column(length = 100)
    private String workMode;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private JobStatus status = JobStatus.OPEN;

    @Column(nullable = false)
    private Boolean active = true;

    private LocalDateTime lastSeenAt;

    private LocalDateTime closedAt;

    @Column(nullable = false)
    private Integer missingCount = 0;
}
