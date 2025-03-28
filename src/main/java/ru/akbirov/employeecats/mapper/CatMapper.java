package ru.akbirov.employeecats.mapper;

import org.mapstruct.Mapper;
import ru.akbirov.employeecats.dto.CatAddDTO;
import ru.akbirov.employeecats.dto.CatUpdateDTO;
import ru.akbirov.employeecats.entity.Cat;

@Mapper(componentModel = "spring")
public interface CatMapper {

    Cat toEntity(CatAddDTO catAddDTO);

    Cat toEntity(CatUpdateDTO catUpdateDTO);

}
