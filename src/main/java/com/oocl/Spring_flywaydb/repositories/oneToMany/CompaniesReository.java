package com.oocl.Spring_flywaydb.repositories.oneToMany;

import com.oocl.Spring_flywaydb.entities.oneToMany.Companies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompaniesReository extends JpaRepository<Companies,Long> {

}
