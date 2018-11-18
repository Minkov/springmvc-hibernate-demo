package com.minkov.springbootdemo.services;

import com.minkov.springbootdemo.dtos.employees.EmployeeCreateDTO;
import com.minkov.springbootdemo.dtos.employees.EmployeeItemDTO;

import java.util.ArrayList;
import java.util.List;

public interface EmployeesService {
    List<EmployeeItemDTO> getAllEmployees();

    void createEmployees(List<EmployeeCreateDTO> employees);

    boolean exists(EmployeeCreateDTO employee);
}
