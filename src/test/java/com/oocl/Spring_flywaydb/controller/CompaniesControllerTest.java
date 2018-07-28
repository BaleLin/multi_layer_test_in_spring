package com.oocl.Spring_flywaydb.controller;

import com.oocl.Spring_flywaydb.controller.dto.oneToMany.CompaniesDTO;
import com.oocl.Spring_flywaydb.controller.oneToMany.CompaniesController;
import com.oocl.Spring_flywaydb.entities.oneToMany.Companies;
import com.oocl.Spring_flywaydb.entities.oneToMany.Employees;
import com.oocl.Spring_flywaydb.service.CompaniesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CompaniesController.class)
public class CompaniesControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CompaniesService companiesService;

    @Test
    public void should_get_all_customers_without_any_paramters()throws Exception{
        //given

        Companies companies1 = new Companies(1L,"oocl");
        Companies companies2 = new Companies(2L,"huawei");
        List<CompaniesDTO> companiesList = Arrays.asList(new CompaniesDTO(companies1),new CompaniesDTO(companies2));
        //when
        given(companiesService.getAllCompanies()).willReturn(companiesList);

        //then
        mockMvc.perform(get("/Companies")).andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[0].id",is(1)))
                .andExpect(jsonPath("$[0].name",is("oocl")))
                .andExpect(jsonPath("$[1].id",is(2)))
                .andExpect(jsonPath("$[1].name",is("huawei")));
}
    @Test
    public void should_return_a_company_when_call_findOne_api()throws Exception{
        //given
        Companies companies = new Companies("oocl");
        CompaniesDTO companiesDTO = new CompaniesDTO(companies);


        //when
            given(companiesService.addCompanies(any(Companies.class))).willReturn(companiesDTO);
            //then
        mockMvc.perform(get("/Companies")).andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[0].name",is("oocl")))
                .andExpect(jsonPath("$[1].name",is("huawei")));
    }

}
