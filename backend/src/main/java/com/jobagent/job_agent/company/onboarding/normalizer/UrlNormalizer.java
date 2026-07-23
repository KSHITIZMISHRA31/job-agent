package com.jobagent.job_agent.company.onboarding.normalizer;

import org.springframework.stereotype.Component;

@Component
public class UrlNormalizer {
    public String normalize(String url){

        if(url == null || url.isBlank()){
            throw new IllegalArgumentException("Career URL cannot be empty");
        }
        url = url.trim();

        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://" + url;
        }

        return url;
    }
}
