package com.minkov.springbootdemo.parsers;

import com.minkov.springbootdemo.dtos.employees.EmployeeCreateDTO;
import com.minkov.springbootdemo.dtos.employees.EmployeeDetailsDTO;
import com.minkov.springbootdemo.dtos.employees.EmployeeItemDTO;
import com.minkov.springbootdemo.parsers.implementations.JsonParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParsersConfiguration {
    @Bean
    Parser<EmployeeCreateDTO> employeeCreateDTOParser() {
        return new JsonParser<>(EmployeeCreateDTO.class, EmployeeCreateDTO[].class);
    }

    @Bean
    Parser<EmployeeItemDTO> employeeItemDTOParser() {
        return new JsonParser<>(EmployeeItemDTO.class, EmployeeItemDTO[].class);
    }

    @Bean
    Parser<EmployeeDetailsDTO> employeeDetailsDTOParser() {
        return new JsonParser<>(EmployeeDetailsDTO.class, EmployeeDetailsDTO[].class);
    }
}
