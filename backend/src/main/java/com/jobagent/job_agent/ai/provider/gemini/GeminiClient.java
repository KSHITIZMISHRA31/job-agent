package com.jobagent.job_agent.ai.provider.gemini;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.genai.types.GenerateContentResponse;
import com.jobagent.job_agent.ai.client.AIClient;
import com.jobagent.job_agent.ai.dto.ResumeAIResponse;
import com.jobagent.job_agent.ai.dto.ResumeAnalysisResult;
import com.jobagent.job_agent.ai.prompt.ResumePromptBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GeminiClient implements AIClient{

    private final ResumePromptBuilder promptBuilder;
    private final ObjectMapper objectMapper;
    private final GeminiExecutionEngine executionEngine;

    @Override
    public ResumeAIResponse analyzeResume(String resumeText) {

        try{
            String prompt = promptBuilder.buildPrompt(resumeText);

            GenerateContentResponse response = executionEngine.execute(prompt);

            String json = response.text();

            log.info("========== AI RESPONSE ==========");
            log.info(json);
            log.info("=================================");

            ResumeAnalysisResult result = objectMapper.readValue(
                    json,
                    ResumeAnalysisResult.class
            );

            return ResumeAIResponse.builder()
                    .result(result)
                    .rawJson(json)
                    .provider("Google")
                    .model(executionEngine.getLastWorkingModel())
                    .build();
        }
        catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Gemini Analysis Failed", e);
        }
    }

    @Override
    public <T> T generateStructuredResponse(String prompt, Class<T> responseType) {
        try {
            GenerateContentResponse response = executionEngine.execute(prompt);
            String json = response.text();

            log.info("========== AI RESPONSE ==========");
            log.info(json);
            log.info("=================================");

            return objectMapper.readValue(json, responseType);
        }
        catch (Exception e) {
            throw new RuntimeException("Gemini Analysis Failed", e);
        }
    }
}
