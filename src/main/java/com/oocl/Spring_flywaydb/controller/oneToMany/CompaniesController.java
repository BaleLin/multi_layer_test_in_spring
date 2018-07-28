package com.oocl.Spring_flywaydb.controller.oneToMany;

import com.oocl.Spring_flywaydb.controller.dto.oneToMany.CompaniesDTO;
import com.oocl.Spring_flywaydb.entities.oneToMany.Companies;
import com.oocl.Spring_flywaydb.repositories.oneToMany.CompaniesReository;
import com.oocl.Spring_flywaydb.repositories.oneToMany.EmployeesReository;
import com.oocl.Spring_flywaydb.service.CompaniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class CompaniesController {
    @Autowired
    private CompaniesService companiesService;



    @Transactional
    @GetMapping("/Companies")
    public List<Companies> getAllCompanies(){
        return companiesService.getAllCompanies();
    }

    @Transactional
    @PostMapping("/Companies")
    public CompaniesDTO addCompanies(@RequestBody Companies companies){
        return companiesService.addCompanies(companies);
    }

    @Transactional
    @PutMapping("/Companies")
    public ResponseEntity<Object> updateCompanies(@RequestBody Companies companies){
       return companiesService.updateCompanies(companies);
    }

    @Transactional
    @GetMapping("/Companies/{id}")
    public CompaniesDTO get(@PathVariable("id") Long id){
       return companiesService.get(id);
    }

    @Transactional
    @DeleteMapping("/Companies/{id}")
    public CompaniesDTO delete(@PathVariable("id")Long id){
        return companiesService.delete(id);
    }

}
