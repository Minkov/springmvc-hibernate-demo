package com.minkov.springbootdemo.services;

import com.minkov.springbootdemo.dtos.DepartmentCreateDTO;
import com.minkov.springbootdemo.dtos.DepartmentDetailsDTO;
import com.minkov.springbootdemo.dtos.DepartmentItemDTO;

import java.util.List;

public interface DepartmentsService {
    List<DepartmentItemDTO> getAllDepartments();

    void create(DepartmentCreateDTO createDTO);

    DepartmentDetailsDTO getDetails(long id);
}
