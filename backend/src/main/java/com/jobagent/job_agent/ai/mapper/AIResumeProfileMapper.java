package com.jobagent.job_agent.ai.mapper;

import com.jobagent.job_agent.ai.dto.ResumeAnalysisResult;
import com.jobagent.job_agent.mongodb.document.AIResumeProfileDocument;
import org.springframework.stereotype.Component;

@Component
public class AIResumeProfileMapper {

    public void updateProfile(AIResumeProfileDocument profile, ResumeAnalysisResult result){

        profile.setCurrentRole(result.getCurrentRole());
        profile.setExperienceYears(result.getExperienceYears());
        profile.setSkills(result.getSkills());
        profile.setPreferredTitles(result.getPreferredTitles());
        profile.setRelatedTitles(result.getRelatedTitles());
        profile.setKeywords(result.getKeywords());
        profile.setIndustry(result.getIndustries());
        profile.setEducation(result.getEducation());
        profile.setCertifications(result.getCertifications());
        profile.setSummary(result.getSummary());

    }
}
