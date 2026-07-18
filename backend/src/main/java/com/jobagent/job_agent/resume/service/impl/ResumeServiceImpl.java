package com.jobagent.job_agent.resume.service.impl;

import com.jobagent.job_agent.ai.client.AIClient;
import com.jobagent.job_agent.ai.dto.AIResponse;
import com.jobagent.job_agent.ai.dto.ResumeAnalysisResult;
import com.jobagent.job_agent.ai.provider.gemini.GeminiExecutionEngine;
import com.jobagent.job_agent.ai.service.ResumeAnalysisService;
import com.jobagent.job_agent.common.util.FileStorageUtil;
import com.jobagent.job_agent.mongodb.service.AIResumeProfileService;
import com.jobagent.job_agent.resume.entity.Resume;
import com.jobagent.job_agent.resume.parser.PdfParser;
import com.jobagent.job_agent.resume.repository.ResumeRepository;
import com.jobagent.job_agent.resume.response.ResumeUploadResponse;
import com.jobagent.job_agent.resume.service.ResumeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService {

    private final ResumeAnalysisService resumeAnalysisService;
    private final ResumeRepository resumeRepository;
    private final FileStorageUtil fileStorageUtil;
    private final PdfParser pdfParser;
    private final AIClient aiClient;
    private final AIResumeProfileService aiResumeProfileService;
    private final GeminiExecutionEngine geminiExecutionEngine;

    @Override
    public ResumeUploadResponse uploadResume(Long userId, MultipartFile file) {

        try{
            String filePath = fileStorageUtil.saveFile(file);

            log.info("1. File saved : "+filePath);
            String extractedText = pdfParser.extractText(filePath);
            log.info("Extracted text - "+extractedText);
            AIResponse aiResponse = aiClient.analyzeResume(extractedText);
            ResumeAnalysisResult analysis = aiResponse.getResult();
            log.info("Anlysed values - "+analysis);
            Resume resume = new Resume();
            log.info("5. Before save");

            resume.setFileName(file.getOriginalFilename());
            resume.setFileType(file.getContentType());
            resume.setFilePath(filePath);
            resume.setExtractedText(extractedText);
            Resume savedResume = resumeRepository.save(resume);

            resumeAnalysisService.saveOrUpdate(savedResume.getId(), aiResponse.getProvider(), aiResponse.getModel(), aiResponse.getRawJson());
            aiResumeProfileService.saveOrUpdate(userId, savedResume.getId(), aiResponse.getProvider(), aiResponse.getModel(), aiResponse.getResult());

            log.info("Saving anlysed data in Mongo");
            aiResumeProfileService.saveOrUpdate(userId, savedResume.getId(),
                    "Google-Gemini",geminiExecutionEngine.getLastWorkingModel(),
                    analysis);


            return ResumeUploadResponse
                    .builder()
                    .resumeId(savedResume.getId())
                    .fileName(savedResume.getFileName())
                    .message("Resume uploaded successfully")
                    .build();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }

    }
}
