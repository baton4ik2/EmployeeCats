package ru.akbirov.employeecats.entity;

import jakarta.persistence.*;

import lombok.Data;

@Entity
@Data
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String color;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
