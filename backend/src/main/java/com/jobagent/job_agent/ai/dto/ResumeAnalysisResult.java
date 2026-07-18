package com.jobagent.job_agent.ai.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResumeAnalysisResult {

    private String currentRole;

    private Double experienceYears;

    private List<String> skills;

    private List<String> preferredTitles;

    private List<String> relatedTitles;

    private List<String> keywords;

    private List<String> industries;

    private List<String> education;

    private List<String> certifications;

    private String summary;
}
