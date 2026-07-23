package com.jobagent.job_agent.company.onboarding.ai;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyAIResponse {

    private String companyName;

    private String website;

    private String careerUrl;

    private String logoUrl;

    private String description;

    private String headquarters;

    private Set<String> industries;

    private Set<String> categories;

    private Set<String> hiringRoles;

    private String platform;

    private String crawlerStrategy;

    private Integer confidence;

}
