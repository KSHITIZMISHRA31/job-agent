package com.jobagent.job_agent.ai.service;

public interface ResumeAnalysisService {

    void saveOrUpdate(Long resumeId,
                      String provider,
                      String model,
                      String json);
}
