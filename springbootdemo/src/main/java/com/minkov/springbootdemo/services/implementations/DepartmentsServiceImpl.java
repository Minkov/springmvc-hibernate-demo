package com.minkov.springbootdemo.services.implementations;

import com.minkov.springbootdemo.dtos.DepartmentCreateDTO;
import com.minkov.springbootdemo.dtos.DepartmentDetailsDTO;
import com.minkov.springbootdemo.dtos.DepartmentItemDTO;
import com.minkov.springbootdemo.entities.Department;
import com.minkov.springbootdemo.repositories.DepartmentsRepository;
import com.minkov.springbootdemo.services.DepartmentsService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class DepartmentsServiceImpl implements DepartmentsService {
    private final DepartmentsRepository departmentsRepository;
    private final ModelMapper mapper;

    public DepartmentsServiceImpl(
            DepartmentsRepository departmentsRepository,
            ModelMapper mapper) {
        this.departmentsRepository = departmentsRepository;
        this.mapper = mapper;
    }

    @Override
    public List<DepartmentItemDTO> getAllDepartments() {
        List<Department> departments = departmentsRepository.findAll();
        Type listOfDepartmentDTOsType = new TypeToken<List<DepartmentItemDTO>>() { }.getType();

        return mapper.map(departments, listOfDepartmentDTOsType);
//        return departments.stream()
//                .map(department -> mapper.map(department, DepartmentItemDTO.class))
//                .collect(Collectors.toList());
    }

    @Override
    public void create(DepartmentCreateDTO createDTO) {
        Department department = mapper.map(createDTO, Department.class);
        departmentsRepository.save(department);
    }

    @Override
    public DepartmentDetailsDTO getDetails(long id) {
        Department department = departmentsRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("Department with id " + id + " not found"));

        return mapper.map(department, DepartmentDetailsDTO.class);
    }
}
