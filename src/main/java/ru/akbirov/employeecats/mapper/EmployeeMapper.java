package ru.akbirov.employeecats.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.akbirov.employeecats.dto.EmployeeAddDTO;
import ru.akbirov.employeecats.dto.EmployeeUpdateDTO;
import ru.akbirov.employeecats.entity.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee toEntity(EmployeeAddDTO employeeAddDTO);

    @Mapping(target = "cats", ignore = true)
    Employee toEntity(EmployeeUpdateDTO employeeUpdateDTO);
}
