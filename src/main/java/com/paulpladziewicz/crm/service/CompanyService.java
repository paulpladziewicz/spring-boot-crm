package com.paulpladziewicz.crm.service;

import com.paulpladziewicz.crm.dto.CompanyDto;
import com.paulpladziewicz.crm.exception.ResourceNotFoundException;
import com.paulpladziewicz.crm.model.Company;
import com.paulpladziewicz.crm.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public void create(CompanyDto companyDto) {
        Company newCompany = new Company();
        mapCompanyAttributes(newCompany, companyDto);
        companyRepository.save(newCompany);
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Optional<Company> findById(int id) {
        return companyRepository.findById(id);
    }

    public void update(CompanyDto companyDto, int id) {
        Company companyToUpdate = companyRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        mapCompanyAttributes(companyToUpdate, companyDto);
        companyRepository.save(companyToUpdate);
    }

    public void delete(int id) {
        companyRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        companyRepository.deleteById(id);
    }

    private void mapCompanyAttributes(Company target, CompanyDto source) {
        target.setName(source.getName());
        target.setIndustry(source.getIndustry());
        target.setAddress(source.getAddress());
        target.setDescription(source.getDescription());
    }
}
