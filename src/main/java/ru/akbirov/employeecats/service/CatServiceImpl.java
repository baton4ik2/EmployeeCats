package ru.akbirov.employeecats.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.akbirov.employeecats.dto.CatGetDTO;
import ru.akbirov.employeecats.entity.Cat;
import ru.akbirov.employeecats.entity.Employee;
import ru.akbirov.employeecats.exception.CatNotFoundException;
import ru.akbirov.employeecats.exception.EmployeeNotFoundException;
import ru.akbirov.employeecats.repository.CatRepository;
import ru.akbirov.employeecats.repository.EmployeeRepository;



@Service
@RequiredArgsConstructor
public class CatServiceImpl implements CatService {

    private final CatRepository catRepository;

    private final EmployeeRepository employeeRepository;

    @Override
    public void add(Cat cat) {
        Employee employee = employeeRepository.findById(cat.getEmployee().getId())
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));

        cat.setEmployee(employee);
        catRepository.save(cat);
    }

    @Override
    public CatGetDTO findById(Long id) {
        Cat cat = catRepository.findById(id).orElseThrow(() -> new CatNotFoundException("Cat not found with id: " + id));
        return new CatGetDTO(cat.getName(), cat.getColor(), cat.getEmployee().getId());
    }

    @Override
    public Cat update(Long id, Cat updatedCat) {
        Cat existingCat = catRepository.findById(id)
                .orElseThrow(() -> new CatNotFoundException("Cat not found with id: " + id));

        existingCat.setName(updatedCat.getName());
        existingCat.setColor(updatedCat.getColor());

        return catRepository.save(existingCat);
    }

    @Override
    public void deleteById(Long id) {
        catRepository.deleteById(id);
    }
}
