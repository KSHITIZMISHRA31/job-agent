package com.jobagent.job_agent.job.discovery.downloader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

@Component
public class HtmlDownloader {

    public Document download(String url){

        try{
            return Jsoup.connect(url)
                    .userAgent("Mozilla/5.0")
                    .timeout(30000)
                    .get();

        } catch (Exception e) {
            throw new RuntimeException("Unable to download page :"+ url,e);
        }

    }

}
