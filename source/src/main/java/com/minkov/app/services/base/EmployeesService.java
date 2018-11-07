package com.minkov.app.services.base;

import com.minkov.app.entities.Employee;

import java.util.List;

public interface EmployeesService {
    List<Employee> listAllEmployees();

    Employee createEmployee(String name);

    List<Employee> listEmployeesFilteredBy(String filter);
}
