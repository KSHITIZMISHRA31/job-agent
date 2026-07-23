package com.jobagent.job_agent.job.discovery.strategy;

import com.jobagent.job_agent.company.entity.Company;
import com.jobagent.job_agent.job.discovery.JobDiscoveryStrategy;
import com.jobagent.job_agent.job.discovery.downloader.HtmlDownloader;
import com.jobagent.job_agent.job.discovery.dto.JobData;
import com.jobagent.job_agent.job.discovery.parser.LinkParser;
import lombok.RequiredArgsConstructor;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class JsoupDiscoveryStrategy implements JobDiscoveryStrategy {

    private final HtmlDownloader downloader;
    private final LinkParser linkParser;


    @Override
    public List<JobData> discover(Company company) {

        Document document = downloader.download(company.getCareerPageUrl());
        System.out.println(document.title());
        System.out.println(document.location());

        Set<String> links = linkParser.extractLinks(document);
        links.forEach(System.out::println);

        return Collections.emptyList();
    }
}
