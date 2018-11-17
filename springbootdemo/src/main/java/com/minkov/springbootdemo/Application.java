package com.minkov.springbootdemo;

import com.minkov.springbootdemo.services.DepartmentsService;
import com.minkov.springbootdemo.services.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Application implements CommandLineRunner {
    @Autowired
    DepartmentsService departmentsService;

    @Autowired
    EmployeesService employeesService;

    @Override
    public void run(String... args) throws Exception {
        departmentsService.getAllDepartments()
                .forEach(System.out::println);

        employeesService.getAllEmployees()
                .forEach(System.out::println);

        System.out.println(departmentsService.getDetails(1));
    }
}
