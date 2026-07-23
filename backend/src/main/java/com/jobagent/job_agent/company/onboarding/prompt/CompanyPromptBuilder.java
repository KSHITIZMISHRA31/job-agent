package com.jobagent.job_agent.company.onboarding.prompt;

import com.jobagent.job_agent.company.onboarding.dto.CompanyMetadata;
import org.springframework.stereotype.Component;

@Component
public class CompanyPromptBuilder {

    public String buildPrompt(CompanyMetadata metadata){

        return """
                You are an expert at analyzing company career websites.
                
                Analyze the HTML provided below and return ONLY valid JSON.
                
                                Rules:
                                1. Return ONLY JSON.
                                2. Do not add markdown.
                                3. Do not explain anything.
                                4. If a value cannot be determined, return null.
                                5. Categories and industries should be arrays.
                                6. Use common industry terminology.
                                7. Keep description under 300 characters.
                
                                JSON Format:
                
                                {
                                  "companyName": "",
                                  "website": "",
                                  "careerUrl": "",
                                  "logoUrl": "",
                                  "description": "",
                                  "headquarters": "",
                                  "industries": [],
                                  "categories": [],
                                  "hiringRoles": [],
                                  "platform": "",
                                  "crawlerStrategy": "",
                                  "confidence": 0
                                }
                
                                Company Name:
                                %s
                
                                Career URL:
                                %s
                
                                HTML:
                
                                %s
                """.formatted(metadata.getCompanyName(),
                metadata.getCareerUrl(),
                metadata.getHtml());

    }

}
