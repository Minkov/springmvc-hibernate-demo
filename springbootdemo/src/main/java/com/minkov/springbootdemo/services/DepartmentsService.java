package com.minkov.springbootdemo.services;

import com.minkov.springbootdemo.dtos.departments.DepartmentCreateDTO;
import com.minkov.springbootdemo.dtos.departments.DepartmentDetailsDTO;
import com.minkov.springbootdemo.dtos.departments.DepartmentItemDTO;

import java.util.List;

public interface DepartmentsService {
    List<DepartmentItemDTO> getAllDepartments();

    void create(DepartmentCreateDTO createDTO);

    DepartmentDetailsDTO getDetails(long id);
}
