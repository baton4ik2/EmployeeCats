package ru.akbirov.employeecats.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.akbirov.employeecats.entity.Cat;
import ru.akbirov.employeecats.exception.CatNotFoundException;
import ru.akbirov.employeecats.repository.CatRepository;

@Service
@RequiredArgsConstructor
public class CatServiceImpl implements CatService {

    private final CatRepository catRepository;

    @Override
    public void add(Cat cat) {
        catRepository.save(cat);
    }

    @Override
    public Cat findById(Long id) {
        return catRepository.findById(id).orElseThrow(() -> new CatNotFoundException("Cat not found with id:" + id));
    }

    @Override
    public Cat update(Long id, Cat updatedCat) {
        Cat existingCat = catRepository.findById(id)
                .orElseThrow(() -> new CatNotFoundException("Cat not found with id: " + id));

        existingCat.setName(updatedCat.getName());
        existingCat.setColor(updatedCat.getColor());
        existingCat.setEmployee(updatedCat.getEmployee());

        return catRepository.save(existingCat);
    }

    @Override
    public void deleteById(Long id) {
        catRepository.deleteById(id);
    }
}
