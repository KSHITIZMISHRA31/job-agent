package com.jobagent.job_agent.ai.provider.gemini;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.genai.types.GenerateContentResponse;
import com.jobagent.job_agent.ai.client.AIClient;
import com.jobagent.job_agent.ai.dto.AIResponse;
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
    public AIResponse analyzeResume(String resumeText) {

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

            return AIResponse.builder()
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
}
