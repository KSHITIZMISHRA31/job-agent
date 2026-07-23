package com.jobagent.job_agent.company.onboarding.downloader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

@Component
public class CompanyHtmlDownloader {

    public Document downlaod(String url){

        try{
            return Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36")
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
                    .header("Accept-Language", "en-US,en;q=0.9")
                    .header("Accept-Encoding", "gzip, deflate, br")
                    .referrer("https://www.google.com/")
                    .timeout(30000)
                    .followRedirects(true)
                    .get();
        }
        catch (Exception e){
            throw new RuntimeException("Unable to download : "+url,e);
        }

    }

}
