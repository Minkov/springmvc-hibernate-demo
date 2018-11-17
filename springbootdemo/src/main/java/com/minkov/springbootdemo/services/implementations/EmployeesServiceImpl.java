package com.minkov.springbootdemo.services.implementations;

import com.minkov.springbootdemo.dtos.EmployeeItemDTO;
import com.minkov.springbootdemo.entities.Employee;
import com.minkov.springbootdemo.repositories.EmployeesRepository;
import com.minkov.springbootdemo.services.EmployeesService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class EmployeesServiceImpl implements EmployeesService {
    private final EmployeesRepository employeesRepository;
    private final ModelMapper mapper;

    @Autowired
    public EmployeesServiceImpl(
            EmployeesRepository employeesRepository,
            ModelMapper mapper
    ) {
        this.employeesRepository = employeesRepository;
        this.mapper = mapper;
    }

    @Override
    public List<EmployeeItemDTO> getAllEmployees() {
        List<Employee> employees = employeesRepository.findAll();
        Type listOfEmployeeItemDTOsType = new TypeToken<List<EmployeeItemDTO>>() { }.getType();
        return mapper.map(employees, listOfEmployeeItemDTOsType);
    }
}
