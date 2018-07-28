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
    public List<CompaniesDTO> getAllCompanies(){
        return companiesService.getAllCompanies();
    }

    @Transactional
    @PostMapping("/Companies")
    public ResponseEntity addCompanies(@RequestBody Companies companies){
        if (companiesService.addCompanies(companies)){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }

    @Transactional
    @PutMapping("/Companies")
    public ResponseEntity updateCompanies(@RequestBody Companies companies){
      if (companiesService.updateCompanies(companies)){
          return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
      }
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @Transactional
    @GetMapping("/Companies/{id}")
    public CompaniesDTO getById(@PathVariable("id") Long id){
       return companiesService.getById(id);
    }

    @Transactional
    @DeleteMapping("/Companies/{id}")
    public ResponseEntity delete(@PathVariable("id")Long id){
        if (companiesService.deleteById(id)){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
