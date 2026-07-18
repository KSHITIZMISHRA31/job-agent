package com.jobagent.job_agent.company.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCompanyRequest {

    private String name;

    private String careerPageUrl;

    private String careerDomain;

    private String logoUrl;

    private String industry;

    private String country;

    private Boolean active;
}
