package com.jobagent.job_agent.resume.response;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResumeUploadResponse {

    private Long resumeId;
    private String fileName;
    private String message;

}
