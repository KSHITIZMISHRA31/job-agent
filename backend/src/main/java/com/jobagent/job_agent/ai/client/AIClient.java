package com.jobagent.job_agent.ai.client;

import com.jobagent.job_agent.ai.dto.ResumeAIResponse;

public interface AIClient {

    ResumeAIResponse analyzeResume(String resumeText);

    <T> T generateStructuredResponse(String prompt, Class<T> responseType);
}
