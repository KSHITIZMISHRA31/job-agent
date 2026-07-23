package com.jobagent.job_agent.job.discovery;

import com.jobagent.job_agent.company.entity.Company;
import com.jobagent.job_agent.job.discovery.dto.JobData;

import java.util.List;

public interface JobDiscoveryStrategy {

    List<JobData> discover(Company company);

}
