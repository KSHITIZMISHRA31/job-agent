package com.jobagent.job_agent.company.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CompanyResponse {
    private Long id;

    private String name;

    private String careerPageUrl;

    private String careerDomain;

    private String logoUrl;

    private String industry;

    private String country;

    private Boolean active;
}
