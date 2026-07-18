package com.jobagent.job_agent.mongodb.document;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Document(collection = "ai_resume_profiles")
public class AIResumeProfileDocument {

    @Id
    private String id;

    // PostgreSQL References
    private Long userId;
    private Long resumeId;

    // AI Information
    private String aiProvider;
    private String aiModel;

    // Resume Analysis
    private String currentRole;

    private Double experienceYears;

    private List<String> skills = new ArrayList<>();

    private List<String> preferredTitles = new ArrayList<>();

    private List<String> relatedTitles = new ArrayList<>();

    private List<String> keywords = new ArrayList<>();

    private List<String> industry = new ArrayList<>();

    private List<String> education = new ArrayList<>();

    private List<String> certifications = new ArrayList<>();

    private String summary;

    private int profileVersion;

    // Audit
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
