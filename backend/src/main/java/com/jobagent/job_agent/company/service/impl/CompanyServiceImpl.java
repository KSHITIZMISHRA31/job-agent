package com.jobagent.job_agent.company.service.impl;

import com.jobagent.job_agent.company.dto.CompanyResponse;
import com.jobagent.job_agent.company.dto.CreateCompanyRequest;
import com.jobagent.job_agent.company.dto.UpdateCompanyRequest;
import com.jobagent.job_agent.company.entity.Company;
import com.jobagent.job_agent.company.mapper.CompanyMapper;
import com.jobagent.job_agent.company.repository.CompanyRepository;
import com.jobagent.job_agent.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Override
    public CompanyResponse createCompany(CreateCompanyRequest request) {
        Company company = companyMapper.toEntity(request);
        Company savedCompany  = companyRepository.save(company);
        return companyMapper.toResponse(savedCompany);
    }

    @Override
    public CompanyResponse updateCompany(Long id, UpdateCompanyRequest request) {

        Company company = companyRepository.findById(id).orElseThrow(() ->
                        new RuntimeException("Company not found"));
        if (request.getName() != null)
            company.setName(request.getName());

        if (request.getCareerPageUrl() != null)
            company.setCareerPageUrl(request.getCareerPageUrl());

        if (request.getCareerDomain() != null)
            company.setCareerDomain(request.getCareerDomain());

        if (request.getLogoUrl() != null)
            company.setLogoUrl(request.getLogoUrl());

        if (request.getIndustry() != null)
            company.setIndustry(request.getIndustry());

        if (request.getCountry() != null)
            company.setCountry(request.getCountry());

        if (request.getActive() != null)
            company.setActive(request.getActive());

        Company updated = companyRepository.save(company);

        return companyMapper.toResponse(updated);

    }

    @Override
    public CompanyResponse getCompany(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Company not found"));

        return companyMapper.toResponse(company);
    }

    @Override
    public List<CompanyResponse> getAllCompanies() {
        return companyRepository.findAll()
                .stream()
                .map(companyMapper::toResponse)
                .toList();
    }

    @Override
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }
}
