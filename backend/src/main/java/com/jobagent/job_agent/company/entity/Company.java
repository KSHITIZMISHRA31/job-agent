package com.jobagent.job_agent.company.entity;

import com.jobagent.job_agent.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "companies", uniqueConstraints =
        {@UniqueConstraint(columnNames = "name"), @UniqueConstraint(columnNames = "career_page_url")})
public class Company extends BaseEntity {
    @Column(nullable = false, length = 150)
    private String name;

    @Column(name = "career_page_url", nullable = false, length = 500)
    private String careerPageUrl;

    @Column(name = "career_domain", nullable = false, length = 150)
    private String careerDomain;

    @Column(name = "logo_url", length = 500)
    private String logoUrl;

    @Column(length = 100)
    private String industry;

    @Column(length = 100)
    private String country;

    @Column(nullable = false)
    private Boolean active = true;

    private LocalDateTime lastSyncedAt;

}
