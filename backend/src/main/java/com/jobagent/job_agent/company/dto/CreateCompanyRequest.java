package com.jobagent.job_agent.company.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCompanyRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String careerPageUrl;

    @NotBlank
    private String careerDomain;

    private String logoUrl;

    private String industry;

    private String country;
}
