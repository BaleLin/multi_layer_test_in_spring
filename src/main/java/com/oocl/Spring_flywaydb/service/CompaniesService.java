package com.oocl.Spring_flywaydb.service;

import com.oocl.Spring_flywaydb.controller.dto.oneToMany.CompaniesDTO;
import com.oocl.Spring_flywaydb.entities.oneToMany.Companies;
import com.oocl.Spring_flywaydb.repositories.oneToMany.CompaniesReository;
import com.oocl.Spring_flywaydb.repositories.oneToMany.EmployeesReository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class CompaniesService {
    @Autowired
    private CompaniesReository companiesReository;

    @Autowired
    private EmployeesReository employeesReository;


    public List<Companies> getAllCompanies(){
        return companiesReository.findAll();
    }


    public CompaniesDTO addCompanies(Companies companies){
        companies.getEmployees().stream().forEach(employees -> {
            employees.setCompanies(companies);
        });
        companiesReository.save(companies);
        return new CompaniesDTO(companies);
    }


    public ResponseEntity<Object> updateCompanies(Companies companies){
        companies.getEmployees().stream().filter(employees -> employees.getCompanies()==null).forEach(employees -> {
            employees.setCompanies(companies);
        });
        companiesReository.save(companies);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    public CompaniesDTO get(Long id){
        Companies companies = companiesReository.findById(id).get();
        return new CompaniesDTO(companies);
    }


    public CompaniesDTO delete(Long id){
        Companies one = companiesReository.findById(id).get();
        companiesReository.delete(one);
        return new CompaniesDTO(one);
    }

}
