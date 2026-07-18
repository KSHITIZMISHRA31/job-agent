package com.jobagent.job_agent.ai.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "gemini")
public class GeminiProperties {

    private Api api = new Api();

    @Getter
    @Setter
    public static class Api {

        private String key;

        private String url;

        private String model;

    }

}
