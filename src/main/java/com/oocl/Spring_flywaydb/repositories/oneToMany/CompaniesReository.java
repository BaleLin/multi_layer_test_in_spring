package com.oocl.Spring_flywaydb.repositories.oneToMany;

import com.oocl.Spring_flywaydb.entities.oneToMany.Companies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CompaniesReository extends JpaRepository<Companies,Long> {
    @Transactional
    int deleteCompaniesById(@Param("id") Long id);
}
