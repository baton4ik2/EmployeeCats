package ru.akbirov.employeecats.service;

import org.springframework.stereotype.Service;

import ru.akbirov.employeecats.dto.CatGetDTO;
import ru.akbirov.employeecats.entity.Cat;


public interface CatService {

    void add(Cat cat);

    CatGetDTO findById(Long id);

    Cat update(Long id, Cat updatedCat);

    void deleteById(Long id);
}
