package com.jobagent.job_agent.ai.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GeminiModel {

    private String name;

    private String displayName;

    private String description;

    private List<String> supportedGenerationMethods;

    private Integer inputTokenLimit;

    private Integer outputTokenLimit;

}
