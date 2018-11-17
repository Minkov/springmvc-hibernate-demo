package com.minkov.springbootdemo.repositories;

import com.minkov.springbootdemo.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentsRepository extends JpaRepository<Department, Long> {
}
