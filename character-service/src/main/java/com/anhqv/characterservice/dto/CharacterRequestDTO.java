package com.anhqv.characterservice.dto;

import com.anhqv.characterservice.model.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;


public record CharacterRequestDTO(

        @NotNull(message = "El nombre no puede ser nulo")
        @NotBlank(message = "El nombre no puede estar vacío")
        @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
        String name,

        @NotNull(message = "El primer apellido no puede ser nulo")
        @NotBlank(message = "El primer apellido no puede estar vacío")
        @Size(min = 2, max = 100, message = "El primer apellido debe tener entre 2 y 100 caracteres")
        String firstSurname,

        @Size(max = 100, message = "El segundo apellido no puede exceder los 100 caracteres")
        String secondSurname,

        @Size(max = 500, message = "La descripción no puede exceder los 500 caracteres")
        String description,

        @NotNull(message = "El género no puede ser nulo")
        Gender gender,

        boolean mainCharacter,

        String imageUrl,

        @PastOrPresent(message = "La fecha de nacimiento no puede ser en el futuro")
        LocalDate dateOfBirth,

        @Size(max = 200, message = "El nombre del actor no puede exceder los 200 caracteres")
        String actorName
) {
}