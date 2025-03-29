package ru.akbirov.employeecats.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.akbirov.employeecats.dto.CatAddDTO;
import ru.akbirov.employeecats.dto.CatGetDTO;
import ru.akbirov.employeecats.dto.CatUpdateDTO;
import ru.akbirov.employeecats.entity.Cat;
import ru.akbirov.employeecats.mapper.CatMapper;
import ru.akbirov.employeecats.service.CatService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/cats")
public class CatController {

    private final CatService catService;

    private final CatMapper catMapper;

    @GetMapping("/{catId}")
    public ResponseEntity<CatGetDTO> get(@PathVariable Long catId) {
        return ResponseEntity.ok(catService.findById(catId));
    }

    @PostMapping
    public ResponseEntity<CatAddDTO> add(@RequestBody CatAddDTO catAddDTO) {

        Cat cat = catMapper.toEntity(catAddDTO);

        catService.add(cat);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(catAddDTO);
    }

    @PutMapping("/{catId}")
    public ResponseEntity<CatUpdateDTO> update(@PathVariable Long catId,
                                                    @RequestBody CatUpdateDTO catUpdateDTO) {
        Cat cat = catMapper.toEntity(catUpdateDTO);

        catService.update(catId, cat);

        return ResponseEntity.ok(catUpdateDTO);
    }

    @DeleteMapping("/{catId}")
    public ResponseEntity<Void> delete(@PathVariable Long catId) {
        catService.deleteById(catId);
        return ResponseEntity.noContent().build();
    }
}
