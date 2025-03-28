package ru.akbirov.employeecats.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.akbirov.employeecats.entity.Cat;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeUpdateDTO {

    private String firstName;

    private String lastName;

    private List<Cat> cat;
}
