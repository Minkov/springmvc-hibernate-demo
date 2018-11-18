package com.minkov.springbootdemo.repositories;

import com.minkov.springbootdemo.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentsRepository extends JpaRepository<Department, Long> {

    Optional<Department> findByName(String name);
}
