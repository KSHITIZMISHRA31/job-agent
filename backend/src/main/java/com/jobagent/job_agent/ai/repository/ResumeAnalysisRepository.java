package com.jobagent.job_agent.ai.repository;

import com.jobagent.job_agent.ai.entity.ResumeAnalysis;
import com.jobagent.job_agent.resume.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResumeAnalysisRepository extends JpaRepository<ResumeAnalysis , Long> {

    Optional<ResumeAnalysis> findByResume(Resume resume);
}
