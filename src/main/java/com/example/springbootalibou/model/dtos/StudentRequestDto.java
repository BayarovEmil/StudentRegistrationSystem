package com.example.springbootalibou.model.dtos;

import jakarta.validation.constraints.NotEmpty;

public record StudentRequestDto(
        @NotEmpty(message = "FirstName should not be empty!")
        String firstname,
        @NotEmpty(message = "Lastname should not be empty!")
        String lastname,
        @NotEmpty(message = "Email should not be empty!")
        String email,
        @NotEmpty(message = "SchoolId should not be empty!")
        Integer schoolId
) {
}
