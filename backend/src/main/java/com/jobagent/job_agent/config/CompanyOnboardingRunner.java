package com.jobagent.job_agent.config;

import com.jobagent.job_agent.company.onboarding.dto.CompanyMetadata;
import com.jobagent.job_agent.company.onboarding.service.CompanyOnboardingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CompanyOnboardingRunner implements CommandLineRunner {

    private final CompanyOnboardingService onboardingService;

    @Override
    public void run(String... args) throws Exception {
        CompanyMetadata metadata = onboardingService.onboard("WellsFargo", "www.wellsfargojobs.com/en/jobs/");

        log.info("Meta deta : "+metadata);
    }
}
