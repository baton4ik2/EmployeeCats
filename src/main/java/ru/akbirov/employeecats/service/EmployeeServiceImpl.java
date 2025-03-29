package ru.akbirov.employeecats.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.akbirov.employeecats.dto.EmployeeGetDTO;
import ru.akbirov.employeecats.dto.EmployeeUpdateDTO;
import ru.akbirov.employeecats.entity.Cat;
import ru.akbirov.employeecats.entity.Employee;
import ru.akbirov.employeecats.exception.EmployeeNotFoundException;
import ru.akbirov.employeecats.repository.CatRepository;
import ru.akbirov.employeecats.repository.EmployeeRepository;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final CatRepository catRepository;

    @Override
    public void add(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public EmployeeGetDTO findById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));

        List<Long> catIds = employee.getCats().stream()
                .map(Cat::getId)
                .collect(Collectors.toList());

        return new EmployeeGetDTO(employee.getFirstName(), employee.getLastName(), catIds);
    }

    @Transactional
    @Override
    public void update(Long employeeId, EmployeeUpdateDTO employeeUpdateDTO) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + employeeId));

        employee.setFirstName(employeeUpdateDTO.getFirstName());
        employee.setLastName(employeeUpdateDTO.getLastName());

        List<Cat> currentCats = employee.getCats();

        List<Cat> updatedCats = catRepository.findAllById(employeeUpdateDTO.getCatIds());

        currentCats.removeIf(cat -> !updatedCats.contains(cat));


        for (Cat cat : updatedCats) {
            if (!currentCats.contains(cat)) {
                cat.setEmployee(employee);
                currentCats.add(cat);
            }
        }

        employee.setCats(currentCats);

        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}
