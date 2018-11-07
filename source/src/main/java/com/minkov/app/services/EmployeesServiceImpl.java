package com.minkov.app.services;

import com.minkov.app.entities.Employee;
import com.minkov.app.repositories.base.DataRepository;
import com.minkov.app.services.base.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeesServiceImpl implements EmployeesService {
    private final DataRepository<Employee> employeesData;

    @Autowired
    public EmployeesServiceImpl(DataRepository<Employee> employeesData) {
        this.employeesData = employeesData;
    }

    @Override
    public List<Employee> listAllEmployees() {
        return employeesData.listAll();
    }

    @Override
    public Employee createEmployee(String name) {
        Employee employee = new Employee(name);
        employeesData.add(employee);
        return employee;
    }

    @Override
    public List<Employee> listEmployeesFilteredBy(String filter) {
        return listAllEmployees()
                .stream()
                .filter(emp -> emp.getName() != null)
                .filter(emp -> emp.getName().contains(filter))
                .collect(Collectors.toList());
    }
}
