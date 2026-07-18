package com.jobagent.job_agent.ai.prompt;


import org.springframework.stereotype.Component;

@Component
public class ResumePromptBuilder {

    public String buildPrompt(String resumeText){

        return """
                You are an expert technical recruiter.
                Analyze the resume.
                Return ONLY VALID JSON.
                Do not write markdown.
                Do not write explanation.
                Do not use ```json.
                Return exactly this format:
                {
                    "currentRole":"",
                    "experienceYears":0,
                    "skills":[],
                    "preferredTitles":[],
                    "relatedTitles":[],
                    "keywords":[],
                    "industry":[],
                    "education":[],
                    "certifications":[],
                    "summary":""
                }
                Resume:
                %s
                """.formatted(resumeText);
    }
}
