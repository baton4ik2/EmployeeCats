package ru.akbirov.employeecats.mapper;

import org.mapstruct.Mapper;
import ru.akbirov.employeecats.dto.EmployeeAddDTO;
import ru.akbirov.employeecats.dto.EmployeeUpdateDTO;
import ru.akbirov.employeecats.entity.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee toEntity(EmployeeAddDTO employeeAddDTO);

    Employee toEntity(EmployeeUpdateDTO employeeUpdateDTO);
}
