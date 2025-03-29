package ru.akbirov.employeecats.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.akbirov.employeecats.dto.CatAddDTO;
import ru.akbirov.employeecats.dto.CatUpdateDTO;
import ru.akbirov.employeecats.entity.Cat;

@Mapper(componentModel = "spring")
public interface CatMapper {

    @Mapping(target = "employee.id", source = "employeeId")
    Cat toEntity(CatAddDTO catAddDTO);

    Cat toEntity(CatUpdateDTO catUpdateDTO);

}
