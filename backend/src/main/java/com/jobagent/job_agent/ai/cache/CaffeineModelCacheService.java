package com.jobagent.job_agent.ai.cache;



import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Optional;

@Service
public class CaffeineModelCacheService implements ModelCacheService{

    private static final String KEY = "LAST_WORKING_MODEL";
    private final Cache<String,String> cache =
            Caffeine.newBuilder()
                    .maximumSize(1)
                    .expireAfterWrite(Duration.ofHours(24))
                    .build();


    @Override
    public Optional<String> getLastWorkingModel() {
        return Optional.ofNullable(cache.getIfPresent(KEY));
    }

    @Override
    public void saveLastWorkingModel(String modelName) {
        cache.put(KEY,modelName);
    }

    @Override
    public void clear() {
        cache.invalidate(KEY);
    }
}
