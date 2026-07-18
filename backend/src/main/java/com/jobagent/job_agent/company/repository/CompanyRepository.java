package com.jobagent.job_agent.company.repository;

import com.jobagent.job_agent.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company,Long> {

    Optional<Company> findByName(String name);

    Optional<Company> findByCareerPageUrl(String careerPageUrl);

    List<Company> findByActiveTrue();

}
