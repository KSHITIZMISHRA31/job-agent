package com.jobagent.job_agent.resume.controller;

import com.jobagent.job_agent.resume.response.ResumeUploadResponse;
import com.jobagent.job_agent.resume.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/resume")
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResumeUploadResponse uploadResume(@RequestParam Long userId, @RequestParam MultipartFile file) {

        return resumeService.uploadResume(userId, file);
    }

}
