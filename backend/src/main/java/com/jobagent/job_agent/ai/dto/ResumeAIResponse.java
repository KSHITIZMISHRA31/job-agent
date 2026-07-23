package com.jobagent.job_agent.ai.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResumeAIResponse {

    private ResumeAnalysisResult result;

    private String rawJson;

    private String provider;

    private String model;
}
