package com.minkov.springbootdemo.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "departments")
public class Department {
    private long id;
    private String name;
    private Set<Employee> employees;


    public Department() {
        employees = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(
            targetEntity = Employee.class,
            mappedBy = "department",
            fetch = FetchType.EAGER
    )
    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}
