package com.oocl.Spring_flywaydb.repositories.oneToMany;

import com.oocl.Spring_flywaydb.entities.oneToMany.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesReository extends JpaRepository<Employees,Long> {
}
