package com.minkov.app.entities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelsConfiguration {
    @Bean
    public Class<Employee> employeeClass() {
        return Employee.class;
    }
}
