package com.anhqv.characterservice.dto;

import com.anhqv.characterservice.model.Gender;

import java.time.LocalDate;

public record CharacterResponseDTO (
        Long id, String name, String firstSurname, String secondSurname,
        String description, Gender gender, String mainCharacter,
        String imageUrl, LocalDate dateOfBirth, String actorName, String isActive

){
}
