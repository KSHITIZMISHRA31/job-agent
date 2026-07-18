package com.jobagent.job_agent.resume.service;

import com.jobagent.job_agent.resume.response.ResumeUploadResponse;
import org.springframework.web.multipart.MultipartFile;

public interface ResumeService {

    ResumeUploadResponse uploadResume(Long userId, MultipartFile file);

}
