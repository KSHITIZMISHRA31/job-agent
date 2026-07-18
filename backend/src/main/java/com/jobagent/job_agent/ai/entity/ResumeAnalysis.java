package com.jobagent.job_agent.ai.entity;

import com.jobagent.job_agent.common.entity.BaseEntity;
import com.jobagent.job_agent.resume.entity.Resume;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "resume_analysis")
public class ResumeAnalysis extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;

    @Column(length = 50)
    private String aiProvider;

    @Column(length = 50)
    private String aiModel;

    @Column(columnDefinition = "TEXT")
    private String analysisJson;

}
