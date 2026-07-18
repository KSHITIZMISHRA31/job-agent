package com.jobagent.job_agent.resume.repository;

import com.jobagent.job_agent.resume.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume,Long> {
}
