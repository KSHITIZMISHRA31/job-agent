package com.jobagent.job_agent.resume.entity;

import com.jobagent.job_agent.common.entity.BaseEntity;
import com.jobagent.job_agent.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "resumes")
public class Resume extends BaseEntity {

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false)
    private String fileType;

    @Column(nullable = false)
    private String filePath;

    @Column(columnDefinition = "TEXT")
    private String extractedText;

    private Double totalExperience;

    private String currentJobTitle;

    @Column(columnDefinition = "TEXT")
    private String generatedTitles;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


}
