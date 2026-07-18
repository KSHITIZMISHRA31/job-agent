package com.jobagent.job_agent.mongodb.service;

import com.jobagent.job_agent.ai.dto.ResumeAnalysisResult;

public interface AIResumeProfileService {

    void saveOrUpdate(Long userId, Long resumeId,String provider, String model, ResumeAnalysisResult result);
}
