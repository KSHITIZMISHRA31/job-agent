package com.jobagent.job_agent.mongodb.repository;

import com.jobagent.job_agent.mongodb.document.AIResumeProfileDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AIResumeProfileRepository extends MongoRepository<AIResumeProfileDocument, String> {

    Optional<AIResumeProfileDocument> findByUserId(Long userId);

}
