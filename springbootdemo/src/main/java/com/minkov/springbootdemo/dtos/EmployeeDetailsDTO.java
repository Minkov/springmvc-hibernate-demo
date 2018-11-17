package com.minkov.springbootdemo.dtos;

import com.minkov.springbootdemo.entities.Employee;
import com.minkov.springbootdemo.mappings.IHaveCustomMappings;
import org.modelmapper.ModelMapper;

public class EmployeeDetailsDTO implements IHaveCustomMappings {
    private long id;
    private String firstName;
    private String lastName;
    private String department;
    private int something;

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
        return "EmployeeDetailsDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    public int getSomething() {
        return something;
    }

    public void setSomething(int something) {
        this.something = something;
    }

    @Override
    public void configureMappings(ModelMapper mapper) {
        mapper.createTypeMap(Employee.class, EmployeeDetailsDTO.class)
                .addMapping(
                        entity -> entity.getDepartment().getName(),
                        (dto, value) -> dto.setDepartment((String) value)
                        // EmployeeDetailsDTO::setDepartment
                )
                .addMappings(m -> m.skip(EmployeeDetailsDTO::setSomething));
    }
}
