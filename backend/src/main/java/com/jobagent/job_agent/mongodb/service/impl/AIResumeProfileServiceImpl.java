package com.jobagent.job_agent.mongodb.service.impl;

import com.jobagent.job_agent.ai.dto.ResumeAnalysisResult;
import com.jobagent.job_agent.ai.mapper.AIResumeProfileMapper;
import com.jobagent.job_agent.mongodb.document.AIResumeProfileDocument;
import com.jobagent.job_agent.mongodb.repository.AIResumeProfileRepository;
import com.jobagent.job_agent.mongodb.service.AIResumeProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AIResumeProfileServiceImpl implements AIResumeProfileService {

    private final AIResumeProfileRepository repository;
    private final AIResumeProfileMapper mapper;

    @Override
    public void saveOrUpdate(Long userId, Long resumeId, String provider, String model, ResumeAnalysisResult result) {

        AIResumeProfileDocument profile = repository.findByUserId(userId).orElse(new AIResumeProfileDocument());

        // PostgreSQL References
        profile.setUserId(userId);
        profile.setResumeId(resumeId);

        // AI Info
        profile.setAiProvider(provider);
        profile.setAiModel(model);

        mapper.updateProfile(profile, result);

        // Version
        if (profile.getProfileVersion() == 0) {
            profile.setProfileVersion(1);
        } else {
            profile.setProfileVersion(profile.getProfileVersion() + 1);
        }
        repository.save(profile);

    }
}
