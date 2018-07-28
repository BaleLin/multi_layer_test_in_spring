package com.oocl.Spring_flywaydb.controller.dto.oneToMany;

import com.oocl.Spring_flywaydb.entities.oneToMany.Employees;

public class EmployeesDTO {
    private final Long id;
    private final String name;
    private final Long companyId;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public EmployeesDTO(Employees employees) {
        this.id = employees.getId();
        this.name = employees.getName();
        this.companyId = employees.getCompanies().getId();
    }
}
