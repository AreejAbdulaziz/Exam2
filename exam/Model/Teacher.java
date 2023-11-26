package com.example.exam.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {
    @Size(min = 6,max = 6,message = "enter id with 3 characters")
    @NotEmpty(message = "teacher id cannot be empty")
    private String id;
    @NotEmpty(message = "teacher name cannot be empty")
    private String name;
    @Positive(message = "enter correct salary")
    @NotNull(message = "teacher salary cannot be empty")
    private double salary;
}
