package com.jobagent.job_agent.ai.provider.gemini;

import com.jobagent.job_agent.ai.dto.GeminiModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GeminiModelsResponse {
    private List<GeminiModel> models;
}
