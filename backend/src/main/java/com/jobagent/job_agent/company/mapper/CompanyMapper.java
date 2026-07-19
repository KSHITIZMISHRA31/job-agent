package com.jobagent.job_agent.company.mapper;

import com.jobagent.job_agent.company.dto.CompanyResponse;
import com.jobagent.job_agent.company.dto.CreateCompanyRequest;
import com.jobagent.job_agent.company.entity.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

    public Company toEntity(CreateCompanyRequest request){
        Company company = new Company();
        company.setName(request.getName());
        company.setCareerPageUrl(request.getCareerPageUrl());
        company.setCareerDomain(request.getCareerDomain());
        company.setLogoUrl(request.getLogoUrl());
        company.setIndustry(request.getIndustry());
        company.setCountry(request.getCountry());
        return company;
    }

    public CompanyResponse toResponse(Company company){

        return CompanyResponse.builder()
                .id(company.getId())
                .name(company.getName())
                .careerPageUrl(company.getCareerPageUrl())
                .careerDomain(company.getCareerDomain())
                .logoUrl(company.getLogoUrl())
                .industry(company.getIndustry())
                .country(company.getCountry())
                .active(company.getActive())
                .build();
    }

}
