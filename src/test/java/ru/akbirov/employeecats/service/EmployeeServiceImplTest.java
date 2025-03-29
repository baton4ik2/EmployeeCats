package ru.akbirov.employeecats.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import ru.akbirov.employeecats.dto.EmployeeGetDTO;
import ru.akbirov.employeecats.dto.EmployeeUpdateDTO;
import ru.akbirov.employeecats.entity.Employee;

import ru.akbirov.employeecats.repository.CatRepository;
import ru.akbirov.employeecats.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private CatRepository catRepository;


    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private Employee employee;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        employee = new Employee(1L, "John", "Doe", new ArrayList<>());
    }

    @Test
    void testAddEmployee() {
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        employeeService.add(employee);

        verify(employeeRepository, times(1)).save(employee);
    }

    @Test
    void testFindEmployeeById() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        EmployeeGetDTO result = employeeService.findById(1L);

        assertNotNull(result);
        assertEquals("John", result.getFirstName());
    }

    @Test
    void testUpdateEmployee() {
        EmployeeUpdateDTO employeeUpdateDTO = new EmployeeUpdateDTO("Jane", "Doe", new ArrayList<>());
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        employeeService.update(1L, employeeUpdateDTO);

        assertEquals("Jane", employee.getFirstName());
    }

    @Test
    void testDeleteEmployee() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        employeeService.deleteById(1L);

        verify(employeeRepository, times(1)).deleteById(1L);
    }
}

