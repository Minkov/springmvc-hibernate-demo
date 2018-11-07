package com.minkov.app.web;

import com.minkov.app.entities.Employee;
import com.minkov.app.services.base.EmployeesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeesApiController {

    private final EmployeesService employeesService;

    public EmployeesApiController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @RequestMapping(
            method = RequestMethod.GET
    )
    public List<Employee> listEmployee(@RequestParam(required = false) String filter) {
        if (filter == null || filter.isBlank()) {
            return employeesService.listAllEmployees();
        }

        return employeesService.listEmployeesFilteredBy(filter);
    }

    @RequestMapping(
            method = RequestMethod.POST
    )
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeesService.createEmployee(employee.getName());
    }
}
