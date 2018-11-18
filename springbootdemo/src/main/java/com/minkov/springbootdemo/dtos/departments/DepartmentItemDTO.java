package com.minkov.springbootdemo.dtos.departments;

import com.minkov.springbootdemo.entities.Department;
import com.minkov.springbootdemo.mappings.IHaveCustomMappings;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;

import java.util.Set;

public class DepartmentItemDTO implements IHaveCustomMappings {
    private String name;

    private Integer employeesSize;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeesSize() {
        return employeesSize;
    }

    public void setEmployeesCount(int employeesSize) {
        this.employeesSize = employeesSize;
    }

    @Override
    public String toString() {
        return "DepartmentItemDTO{" +
                "name='" + name + '\'' +
                ", employeesCount=" + employeesSize +
                '}';
    }

    @Override
    public void configureMappings(ModelMapper mapper) {
        Converter<Set, Integer> countConverter =
                ctx -> ctx.getSource().size();

        mapper.createTypeMap(Department.class, DepartmentItemDTO.class)
                .addMappings(map -> map
                        .using(countConverter)
                        .map(
                                Department::getEmployees,
                                DepartmentItemDTO::setEmployeesCount
                        )
                );
    }
}
