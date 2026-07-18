package com.jobagent.job_agent.ai.provider.gemini;

import com.jobagent.job_agent.ai.config.GeminiProperties;
import com.jobagent.job_agent.ai.dto.GeminiModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class GeminiModelDiscovery {

    private final GeminiProperties properties;

    private final RestClient restClient = RestClient.builder().build();

    public List<GeminiModel> discoverModels(){

        String url = properties.getApi().getUrl()
                +"/models?key="
                +properties.getApi().getKey();



        GeminiModelsResponse response = restClient.get()
                .uri(url)
                .retrieve()
                .body(GeminiModelsResponse.class);

        return response.getModels();

    }

}
