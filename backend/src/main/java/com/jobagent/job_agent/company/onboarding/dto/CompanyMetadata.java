package com.jobagent.job_agent.company.onboarding.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyMetadata {
    private String companyName;

    private String careerUrl;

    /**
     * Raw HTML downloaded from the career page.
     */
    private String html;
}
