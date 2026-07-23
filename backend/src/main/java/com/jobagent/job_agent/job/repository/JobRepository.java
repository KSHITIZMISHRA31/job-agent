package com.jobagent.job_agent.job.repository;

import com.jobagent.job_agent.company.entity.Company;
import com.jobagent.job_agent.job.entity.Job;
import com.jobagent.job_agent.job.entity.JobStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface JobRepository extends JpaRepository<Job , Long> {

    Optional<Job> findByCompanyAndJobPageUrl(Company company,String jobPageUrl);

    boolean existsByCompanyAndJobPageUrl(Company company, String jobPageUrl);

    List<Job> findByCompany(Company company);

    List<Job> findByCompanyAndStatus(Company company, JobStatus status);

    List<Job> findByStatus(JobStatus status);

    List<Job> findByActiveTrue();

    List<Job> findByCompanyAndActiveTrue(Company company);

    List<Job> findByLastSeenAtBefore(LocalDateTime dateTime);
}
