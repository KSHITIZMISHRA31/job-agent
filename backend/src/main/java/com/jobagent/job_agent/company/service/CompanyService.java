package com.jobagent.job_agent.company.service;

import com.jobagent.job_agent.company.dto.CompanyResponse;
import com.jobagent.job_agent.company.dto.CreateCompanyRequest;
import com.jobagent.job_agent.company.dto.UpdateCompanyRequest;

import java.util.List;

public interface CompanyService {

    CompanyResponse createCompany(CreateCompanyRequest request);

    CompanyResponse updateCompany(Long id,
                                  UpdateCompanyRequest request);

    CompanyResponse getCompany(Long id);

    List<CompanyResponse> getAllCompanies();

    void deleteCompany(Long id);

}
