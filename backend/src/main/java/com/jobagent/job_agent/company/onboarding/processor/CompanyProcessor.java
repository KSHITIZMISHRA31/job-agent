package com.jobagent.job_agent.company.onboarding.processor;

import com.jobagent.job_agent.company.onboarding.downloader.CompanyHtmlDownloader;
import com.jobagent.job_agent.company.onboarding.dto.CompanyMetadata;
import com.jobagent.job_agent.company.onboarding.normalizer.UrlNormalizer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CompanyProcessor {

    private final UrlNormalizer urlNormalizer;
    private final CompanyHtmlDownloader downloader;

    public CompanyMetadata process(String companyName, String careerUrl){

        String normalizedUrl = urlNormalizer.normalize(careerUrl);
        Document document = downloader.downlaod(normalizedUrl);

        log.info("===============================");
        log.info("Company : "+ companyName);
        log.info("Title   : "+ document.title());
        log.info("Url     : "+ document.location());
        log.info("===============================");


        return CompanyMetadata.builder()
                .companyName(companyName)
                .careerUrl(document.location())
                .build();

    }


}
