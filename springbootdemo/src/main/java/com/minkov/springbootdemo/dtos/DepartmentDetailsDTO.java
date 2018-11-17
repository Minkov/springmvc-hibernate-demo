package com.minkov.springbootdemo.dtos;

import java.util.Set;

public class DepartmentDetailsDTO {
    private long id;
    private String name;
    private Set<EmployeeItemDTO> employees;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<EmployeeItemDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeeItemDTO> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "DepartmentDetailsDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}
