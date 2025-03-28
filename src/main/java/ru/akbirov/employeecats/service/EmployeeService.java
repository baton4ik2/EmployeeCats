package ru.akbirov.employeecats.service;

import org.springframework.stereotype.Service;
import ru.akbirov.employeecats.entity.Employee;

import java.util.Optional;


public interface EmployeeService {

    void add(Employee employee);

    Employee findById(Long id);

    Employee update(Long id, Employee updatedEmployee);

    void deleteById(Long id);
}
