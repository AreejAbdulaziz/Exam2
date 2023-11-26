package com.example.exam.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    @Size(min = 6,max = 6,message = "enter id with 3 characters")
    @NotEmpty(message = "student id cannot be empty")
    private String id;
    @NotEmpty(message = "student name cannot be empty")
    private String name;
    @NotNull(message = "age cannot be null")
    @Positive(message = "enter correct age")
    private int age;
    @NotEmpty(message = "student major cannot be empty")
    private String major;
}
