package com.paulpladziewicz.crm.dto;

import jakarta.validation.constraints.NotBlank;

public class CompanyDto {

    @NotBlank(message = "Please provide a name.")
    private String name;

    @NotBlank(message = "Please provide an industry.")
    private String industry;

    private String address;

    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
