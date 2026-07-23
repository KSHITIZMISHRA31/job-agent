package com.jobagent.job_agent.job.discovery.parser;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

@Component
public class LinkParser {

    public Set<String> extractLinks(Document document){
        Set<String> links = new LinkedHashSet<>();

        for(Element element : document.select("a[href]") ){
            String href = element.absUrl("href");
            if(!href.isBlank()){
                links.add(href);
            }
        }
        return links;
    }

}
