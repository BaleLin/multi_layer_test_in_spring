package com.oocl.Spring_flywaydb.service;

import com.oocl.Spring_flywaydb.controller.dto.oneToMany.EmployeesDTO;
import com.oocl.Spring_flywaydb.entities.oneToMany.Employees;
import com.oocl.Spring_flywaydb.repositories.oneToMany.EmployeesReository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeesService {
    @Autowired
    private EmployeesReository employeesReository;

    public List<EmployeesDTO> getAllCompanies(){
        return employeesReository.findAll().stream().map(item->
                new EmployeesDTO(item)).collect(Collectors.toList());
    }
}
