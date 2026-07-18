package com.jobagent.job_agent.ai.config;

import com.google.genai.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class GeminiConfig {
    private final GeminiProperties properties;

    @Bean(name = "googleGeminiClient")
    public Client geminiClient() {

        return Client.builder()
                .apiKey(properties.getApi().getKey())
                .build();
    }
}
