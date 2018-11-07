package com.minkov.app.entities;

import com.minkov.app.entities.base.DbEntity;

import javax.persistence.*;


@Entity(name = "employees")
public class Employee extends DbEntity {
    private String name;

    public Employee() {

    }

    public Employee(String name) {
        setName(name);
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }
}
