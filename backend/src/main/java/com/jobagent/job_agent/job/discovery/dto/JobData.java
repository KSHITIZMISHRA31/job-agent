package com.jobagent.job_agent.job.discovery.dto;

import kotlin.text.UStringsKt;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class JobData {
    private String title;
    private String description;
    private String jobPageUrl;
    private String applyUrl;
    private String location;
    private String employmentType;
    private String experience;
    private String department;
    private String jobType;
    private String workMode;
    private LocalDate postedDate;
}
