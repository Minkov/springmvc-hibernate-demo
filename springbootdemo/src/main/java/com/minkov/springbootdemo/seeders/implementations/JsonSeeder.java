package com.minkov.springbootdemo.seeders.implementations;

import com.minkov.springbootdemo.dtos.employees.EmployeeCreateDTO;
import com.minkov.springbootdemo.parsers.Parser;
import com.minkov.springbootdemo.seeders.Seeder;
import com.minkov.springbootdemo.services.EmployeesService;
import com.minkov.springbootdemo.utils.ResourceFileReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class JsonSeeder implements Seeder {
    private final EmployeesService employeesService;
    private final String seedFileName;
    private final Parser<EmployeeCreateDTO> parser;
    private final ResourceFileReader resourceFileReader;

    public JsonSeeder(
            EmployeesService employeesService,
            @Qualifier("seed-file-name") String seedFileName,
            Parser<EmployeeCreateDTO> parser,
            ResourceFileReader resourceFileReader) {
        this.employeesService = employeesService;
        this.seedFileName = seedFileName;
        this.parser = parser;
        this.resourceFileReader = resourceFileReader;
    }

    @Override
    public void seed() throws IOException {
        seedEmployees();
    }

    private void seedEmployees() throws IOException {
        String json = resourceFileReader.readResourceFile(seedFileName);
        var employees = Arrays.stream(parser.fromListString(json))
                .filter(emp -> !employeesService.exists(emp))
                .collect(Collectors.toList());

        employeesService.createEmployees(employees);
    }
}
