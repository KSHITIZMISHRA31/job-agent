package com.jobagent.job_agent.company.onboarding.service;

import com.jobagent.job_agent.company.entity.Company;

public interface CompanyOnboardingService {

    Company onboard(String companyName, String careerUrl);

}