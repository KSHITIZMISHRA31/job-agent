package com.jobagent.job_agent.config;

import com.jobagent.job_agent.company.repository.CompanyRepository;
import com.jobagent.job_agent.job.discovery.strategy.JsoupDiscoveryStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartupRunner implements CommandLineRunner {

    private final CompanyRepository companyRepository;
    private final JsoupDiscoveryStrategy strategy;

    @Override
    public void run(String... args) throws Exception {
        companyRepository.findAll()
                .stream()
                .findFirst()
                .ifPresent(strategy::discover);
    }
}
