package com.minkov.springbootdemo.dtos;

import com.minkov.springbootdemo.entities.Department;
import com.minkov.springbootdemo.entities.Employee;
import com.minkov.springbootdemo.mappings.IHaveCustomMappings;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public class EmployeeCreateDTO implements IHaveCustomMappings {
    private String firstName;
    private String lastName;
    private String department;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "EmployeeCreateDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    @Override
    public void configureMappings(ModelMapper mapper) {
        Converter nameToDepartment = ctx ->
        {
            Department department = new Department();
            department.setName((String) ctx.getSource());
            return department;
        };

        mapper.createTypeMap(EmployeeCreateDTO.class, Employee.class)
                .addMappings(map -> map.using(nameToDepartment).map(
                        EmployeeCreateDTO::getDepartment,
                        Employee::setDepartment
                ))
                .addMappings(m -> m.skip(Employee::setId));
    }
}
