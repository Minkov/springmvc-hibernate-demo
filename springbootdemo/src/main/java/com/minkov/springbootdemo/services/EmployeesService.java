package com.minkov.springbootdemo.services;

import com.minkov.springbootdemo.dtos.EmployeeCreateDTO;
import com.minkov.springbootdemo.dtos.EmployeeItemDTO;

import java.util.List;

public interface EmployeesService {
    List<EmployeeItemDTO> getAllEmployees();

    void createMany(List<EmployeeCreateDTO> employees);
}
