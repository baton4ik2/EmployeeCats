package ru.akbirov.employeecats.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.akbirov.employeecats.dto.EmployeeAddDTO;
import ru.akbirov.employeecats.dto.EmployeeUpdateDTO;
import ru.akbirov.employeecats.entity.Employee;
import ru.akbirov.employeecats.mapper.EmployeeMapper;
import ru.akbirov.employeecats.service.EmployeeService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    private final EmployeeMapper employeeMapper;

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> get(@PathVariable Long employeeId) {
        return ResponseEntity.ok(employeeService.findById(employeeId));
    }

    @PostMapping
    public ResponseEntity<EmployeeAddDTO> add(@RequestBody EmployeeAddDTO employeeAddDTO) {

        Employee employee = employeeMapper.toEntity(employeeAddDTO);

        employeeService.add(employee);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(employeeAddDTO);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeUpdateDTO> update(@PathVariable Long employeeId,
                                                    @RequestBody EmployeeUpdateDTO employeeUpdateDTO) {
        Employee employee = employeeMapper.toEntity(employeeUpdateDTO);

        employeeService.update(employeeId, employee);

        return ResponseEntity.ok(employeeUpdateDTO);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> delete(@PathVariable Long employeeId) {
        employeeService.deleteById(employeeId);
        return ResponseEntity.noContent().build();
    }
}
