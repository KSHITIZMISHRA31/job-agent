package com.jobagent.job_agent.ai.service.impl;

import com.jobagent.job_agent.ai.entity.ResumeAnalysis;
import com.jobagent.job_agent.ai.repository.ResumeAnalysisRepository;
import com.jobagent.job_agent.ai.service.ResumeAnalysisService;
import com.jobagent.job_agent.resume.entity.Resume;
import com.jobagent.job_agent.resume.repository.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResumeAnalysisServiceImpl implements ResumeAnalysisService {

    private final ResumeAnalysisRepository repository;
    private final ResumeRepository resumeRepository;

    @Override
    public void saveOrUpdate(Long resumeId, String provider, String model, String json) {

        Resume resume = resumeRepository.findById(resumeId).orElseThrow();

        ResumeAnalysis analysis = repository.findByResume(resume).orElse(new ResumeAnalysis());

        analysis.setResume(resume);
        analysis.setAiProvider(provider);
        analysis.setAiModel(model);
        analysis.setAnalysisJson(json);

        repository.save(analysis);

    }
}
