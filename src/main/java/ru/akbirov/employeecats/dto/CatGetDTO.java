package ru.akbirov.employeecats.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatGetDTO {

    private String name;

    private String color;

    private Long employeeIds;
}
