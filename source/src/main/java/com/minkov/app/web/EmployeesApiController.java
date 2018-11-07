package com.minkov.app.web;

import com.minkov.app.entities.Employee;
import com.minkov.app.repositories.base.DataRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeesApiController {

    private final DataRepository<Employee> employeeData;

    public EmployeesApiController(DataRepository<Employee> employeeData) {
        this.employeeData = employeeData;
    }

    @RequestMapping(
            method = RequestMethod.GET
    )
    public List<Employee> listEmployee() {
        return employeeData.listAll();
    }

    @RequestMapping(
            method = RequestMethod.POST
    )
    public Employee createEmployee(@RequestBody Employee employee) {
        employeeData.add(employee);
        return employee;
    }
}
