package com.minkov.app;

import com.minkov.app.entities.Employee;
import com.minkov.app.repositories.EmployeesDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringhibernatedemoApplication {
    @Autowired
    public SpringhibernatedemoApplication(EmployeesDataRepository employeesData) {
        employeesData.add(new Employee("John", "Doe"));
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringhibernatedemoApplication.class, args);

    }
}
