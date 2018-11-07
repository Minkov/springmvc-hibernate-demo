package com.minkov.app.repositories;

import com.minkov.app.entities.Employee;
import com.minkov.app.repositories.base.DataRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeesDataRepository implements DataRepository<Employee> {
    private static List<Employee> items;

    static {
        items = new ArrayList<>();
    }

    @Override
    public List<Employee> list() {
        return items;
    }

    @Override
    public void add(Employee item) {
        int lastId = list()
                .stream()
                .mapToInt(Employee::getId)
                .max()
                .orElse(0);

        item.setId(lastId + 1);
        items.add(item);
    }
}
