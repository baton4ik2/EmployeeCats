package ru.akbirov.employeecats.service;

import org.springframework.stereotype.Service;
import ru.akbirov.employeecats.dto.EmployeeGetDTO;
import ru.akbirov.employeecats.dto.EmployeeUpdateDTO;
import ru.akbirov.employeecats.entity.Employee;

import java.util.Optional;


public interface EmployeeService {

    void add(Employee employee);

    EmployeeGetDTO findById(Long id);

    void update(Long employeeId, EmployeeUpdateDTO employeeUpdateDTO);

    void deleteById(Long id);
}
