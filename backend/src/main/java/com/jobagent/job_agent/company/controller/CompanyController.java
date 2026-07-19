package com.jobagent.job_agent.company.controller;

import com.jobagent.job_agent.company.dto.CompanyResponse;
import com.jobagent.job_agent.company.dto.CreateCompanyRequest;
import com.jobagent.job_agent.company.dto.UpdateCompanyRequest;
import com.jobagent.job_agent.company.service.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    public CompanyResponse createCompany(@Valid @RequestBody CreateCompanyRequest request) {
        return companyService.createCompany(request);
    }

    @GetMapping("/{id}")
    public CompanyResponse getCompany(@PathVariable Long id){
        return companyService.getCompany(id);
    }

    @GetMapping()
    public List<CompanyResponse> getAllCompanies(){
        return companyService.getAllCompanies();
    }

    @PutMapping("/{id}")
    public CompanyResponse updateCompany(@PathVariable Long id, @RequestBody UpdateCompanyRequest request) {
        return companyService.updateCompany(id, request);
    }
    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable Long id) {

        companyService.deleteCompany(id);
    }

}
