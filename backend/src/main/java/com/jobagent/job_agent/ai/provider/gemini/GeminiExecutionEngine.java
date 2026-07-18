package com.jobagent.job_agent.ai.provider.gemini;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import com.jobagent.job_agent.ai.cache.ModelCacheService;
import com.jobagent.job_agent.ai.dto.GeminiModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class GeminiExecutionEngine {

    @Qualifier("googleGeminiClient")
    private final Client geminiClient;

    private final ModelCacheService cacheService;
    private final GeminiModelDiscovery modelDiscovery;
    private String lastWorkingModel;

    public GenerateContentResponse execute(String prompt) {

        // 1. Try cache
        Optional<String> cachedModel = cacheService.getLastWorkingModel();
        // We'll implement this next

        if(cachedModel.isPresent()){
            try{
                log.info("Trying cached model : {}", cachedModel.get());
                return invokeModel(cachedModel.get(), prompt);
            }
            catch (Exception e) {
                log.warn("Cached model failed : {}", cachedModel.get());
                cacheService.clear();
            }
        }

            // Step 2: Discover all available models
            List<GeminiModel> models = modelDiscovery.discoverModels();

            for(GeminiModel model: models){
                // Skip models that don't support generateContent
                if (model.getSupportedGenerationMethods() == null
                        || !model.getSupportedGenerationMethods().contains("generateContent"))
                {
                    continue;
                }
                try{
                    log.info("Trying model : {}", model.getName());
                    GenerateContentResponse response =
                            invokeModel(model.getName(), prompt);
                    cacheService.saveLastWorkingModel(model.getName());
                    log.info("Working model cached : {}", model.getName());
                    lastWorkingModel = model.getName();
                    return response;
                }
                catch (Exception ex) {
                    log.warn("Model {} failed", model.getName());
                }
            }
        throw new RuntimeException("No Gemini model succeeded.");
    }

    public String getLastWorkingModel() {
        return lastWorkingModel;
    }

    private GenerateContentResponse invokeModel(String model, String prompt) {

        return geminiClient.models.generateContent(
                model,
                prompt,
                null
        );
    }
}
