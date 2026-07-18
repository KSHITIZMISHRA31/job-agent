package com.jobagent.job_agent.ai.cache;

import java.util.Optional;

public interface ModelCacheService {

    Optional<String> getLastWorkingModel();

    void saveLastWorkingModel(String modelName);

    void clear();
}
