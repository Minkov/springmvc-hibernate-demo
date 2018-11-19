package com.minkov.springbootdemo;

import com.minkov.springbootdemo.dtos.EmployeeCreateDTO;
import com.minkov.springbootdemo.parsers.Parser;
import com.minkov.springbootdemo.services.DepartmentsService;
import com.minkov.springbootdemo.services.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Component
public class Application implements CommandLineRunner {
    @Autowired
    DepartmentsService departmentsService;

    @Autowired
    EmployeesService employeesService;

    @Autowired
    Parser parser;

    @Override
    public void run(String... args) throws Exception {
        departmentsService.getAllDepartments()
                .forEach(System.out::println);

//        List<EmployeeItemDTO> employees =
//                employeesService.getAllEmployees();

        // 1. Read the file to get the JSON
        String json = readJson();
        System.out.println(json);
        // 2. Parse the JSON to EmployeeDTOs

        List<EmployeeCreateDTO> employees =
                Arrays.asList(parser.fromString(json, EmployeeCreateDTO[].class));

        // 3. Persist into the Database
        employeesService.createMany(employees);
    }

    private String readJson() throws IOException {
        File file = new ClassPathResource("seed.json")
                .getFile();

        Scanner in = new Scanner(new FileReader(file));
        StringBuilder json = new StringBuilder();
        while (in.hasNext()) {
            json.append(in.nextLine());
            json.append("\n");
        }

        return json.toString();
    }
}
