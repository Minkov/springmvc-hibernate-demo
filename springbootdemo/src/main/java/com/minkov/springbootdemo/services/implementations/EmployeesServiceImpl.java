package com.minkov.springbootdemo.services.implementations;

import com.minkov.springbootdemo.dtos.employees.EmployeeCreateDTO;
import com.minkov.springbootdemo.dtos.employees.EmployeeItemDTO;
import com.minkov.springbootdemo.entities.Department;
import com.minkov.springbootdemo.entities.Employee;
import com.minkov.springbootdemo.repositories.DepartmentsRepository;
import com.minkov.springbootdemo.repositories.EmployeesRepository;
import com.minkov.springbootdemo.services.EmployeesService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeesServiceImpl implements EmployeesService {
    private final EmployeesRepository employeesRepository;
    private final ModelMapper mapper;
    private final DepartmentsRepository departmentsRepository;

    @Autowired
    public EmployeesServiceImpl(
            EmployeesRepository employeesRepository,
            DepartmentsRepository departmentsRepository,
            ModelMapper mapper
    ) {
        this.employeesRepository = employeesRepository;
        this.departmentsRepository = departmentsRepository;
        this.mapper = mapper;
    }

    @Override
    public List<EmployeeItemDTO> getAllEmployees() {
        List<Employee> employees = employeesRepository.findAll();
        Type listOfEmployeeItemDTOsType = new TypeToken<List<EmployeeItemDTO>>() {
        }.getType();
        return mapper.map(employees, listOfEmployeeItemDTOsType);
    }

    @Override
    @Transactional
    public void createEmployees(List<EmployeeCreateDTO> employeeDtos) {
        Type listOfEmployeesClass = new TypeToken<List<Employee>>() {
        }.getType();
        List<Employee> employees = mapper.map(employeeDtos, listOfEmployeesClass);
        employees.forEach(employee -> {
                    var department = departmentsRepository.findByName(employee.getDepartment().getName())
                            .orElse(null);
                    if (department == null) {
                        departmentsRepository.save(employee.getDepartment());
                    } else {
                        employee.setDepartment(department);
                    }
                }
        );

        employeesRepository.saveAll(employees);
    }

    @Override
    public boolean exists(EmployeeCreateDTO employee) {
        return employeesRepository.existsByFirstNameAndLastName(employee.getFirstName(), employee.getLastName());
    }
}
