package com.minkov.springbootdemo.services.implementations;

import com.minkov.springbootdemo.dtos.EmployeeCreateDTO;
import com.minkov.springbootdemo.dtos.EmployeeItemDTO;
import com.minkov.springbootdemo.entities.Department;
import com.minkov.springbootdemo.entities.Employee;
import com.minkov.springbootdemo.repositories.DepartmentsRepository;
import com.minkov.springbootdemo.repositories.EmployeesRepository;
import com.minkov.springbootdemo.services.EmployeesService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeesServiceImpl implements EmployeesService {
    private final EmployeesRepository employeesRepository;
    private final DepartmentsRepository departmentsRepository;
    private final ModelMapper mapper;

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

        Type listOfEmployeeItemDTOsType =
                new TypeToken<List<EmployeeItemDTO>>() {}.getType();

        return mapper.map(employees, listOfEmployeeItemDTOsType);
    }

    @Override
    public void createMany(List<EmployeeCreateDTO> employees) {
        List<Employee> entities = employees
                .stream()
                .map(dto -> mapper.map(dto, Employee.class))
                .filter(employee -> !employeesRepository
                        .existsByFirstNameAndLastName(
                                employee.getFirstName(),
                                employee.getLastName()
                        ))
                .collect(Collectors.toList());

        entities
                .forEach(employee -> {
                    Department department = departmentsRepository.findByName(employee.getDepartment().getName());
                    if (department == null) {
                        departmentsRepository.save(employee.getDepartment());
                    } else {
                        employee.setDepartment(department);
                    }

                });
        employeesRepository.saveAll(entities);
    }
}
