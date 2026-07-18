package com.jobagent.job_agent.ai.client;

import com.jobagent.job_agent.ai.dto.AIResponse;

public interface AIClient {

    AIResponse analyzeResume(String resumeText);
}
