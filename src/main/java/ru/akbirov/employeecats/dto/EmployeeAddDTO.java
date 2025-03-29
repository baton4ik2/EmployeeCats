package ru.akbirov.employeecats.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeAddDTO {

    private String firstName;

    private String lastName;

}
