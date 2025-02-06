package com.paulpladziewicz.crm.controller;

import com.paulpladziewicz.crm.dto.CompanyDto;
import com.paulpladziewicz.crm.exception.ResourceNotFoundException;
import com.paulpladziewicz.crm.model.Company;
import com.paulpladziewicz.crm.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController()
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/create/company")
    @ResponseStatus(HttpStatus.OK)
    public String  createCompany(@RequestBody @Valid CompanyDto company) {

        companyService.create(company);
        return "Company created";
    }

    @GetMapping("/companies")
    public List<Company> getCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("/company/{id}")
    public Company getCompany(@PathVariable int id) {
        Optional<Company> company = companyService.findById(id);
        if (company.isPresent()) {
            return company.get();
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @PutMapping("/update/company/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String updateCompany(@RequestBody @Valid CompanyDto company, @PathVariable int id) {
        companyService.update(company, id);
        return "Company updated";
    }

    @DeleteMapping("/delete/company/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteCompany(@PathVariable int id) {
        companyService.delete(id);
        return "Company deleted";
    }
}
