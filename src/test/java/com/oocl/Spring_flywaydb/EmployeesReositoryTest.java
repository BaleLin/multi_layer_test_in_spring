package com.oocl.Spring_flywaydb;

import com.oocl.Spring_flywaydb.entities.oneToMany.Employees;
import com.oocl.Spring_flywaydb.repositories.oneToMany.EmployeesReository;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeesReositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    EmployeesReository employeesReository;

    @Test
    public void should_find_no_employees_if_respository_is_empty(){
        Iterable<Employees> employees = employeesReository.findAll();
        assertThat(employees).isEmpty();
    }

    @Test
    public void should_save_successful_if_save_employees_to_respository(){

        Employees employees = employeesReository.save(new Employees("liming"));
        assertThat(employees).hasFieldOrPropertyWithValue("name","liming");
    }

    @Test
    public void should_update_successful_if_save_employees_to_respository(){

        Employees employees = employeesReository.save(new Employees("liming"));
        assertThat(employees).hasFieldOrPropertyWithValue("name","liming");
    }
}
