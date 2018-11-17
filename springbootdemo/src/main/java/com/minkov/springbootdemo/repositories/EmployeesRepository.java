package com.minkov.springbootdemo.repositories;

import com.minkov.springbootdemo.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employee, Long> {
}
