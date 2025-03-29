package ru.akbirov.employeecats.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import ru.akbirov.employeecats.dto.CatGetDTO;
import ru.akbirov.employeecats.entity.Cat;
import ru.akbirov.employeecats.entity.Employee;
import ru.akbirov.employeecats.repository.CatRepository;
import ru.akbirov.employeecats.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CatServiceImplTest {

    @Mock
    private CatRepository catRepository;

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private CatServiceImpl catService;

    private Cat cat;
    private Employee employee;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        employee = new Employee(1L, "John", "Doe", new ArrayList<>());
        cat = new Cat(1L, "Fluffy", "White", employee);
    }

    @Test
    void testAddCat() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
        when(catRepository.save(any(Cat.class))).thenReturn(cat);

        catService.add(cat);

        verify(catRepository, times(1)).save(cat);
    }

    @Test
    void testFindCatById() {
        when(catRepository.findById(1L)).thenReturn(Optional.of(cat));

        CatGetDTO result = catService.findById(1L);

        assertNotNull(result);
        assertEquals("Fluffy", result.getName());
    }

    @Test
    void testUpdateCat() {
        Cat updatedCat = new Cat(1L, "Fluffy", "Black", employee);
        when(catRepository.findById(1L)).thenReturn(Optional.of(cat));
        when(catRepository.save(any(Cat.class))).thenReturn(updatedCat);

        Cat result = catService.update(1L, updatedCat);

        assertEquals("Black", result.getColor());
    }

    @Test
    void testDeleteCat() {
        when(catRepository.findById(1L)).thenReturn(Optional.of(cat));

        catService.deleteById(1L);

        verify(catRepository, times(1)).deleteById(1L);
    }
}
