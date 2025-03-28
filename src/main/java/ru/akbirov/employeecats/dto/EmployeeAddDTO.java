package ru.akbirov.employeecats.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import ru.akbirov.employeecats.entity.Cat;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeAddDTO {

    private String firstName;

    private String lastName;

    private List<Cat> cats;
}
