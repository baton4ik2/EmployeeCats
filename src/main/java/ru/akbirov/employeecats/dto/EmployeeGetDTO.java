package ru.akbirov.employeecats.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeGetDTO {

    private String firstName;

    private String lastName;

    private List<Long> catIds;
}
