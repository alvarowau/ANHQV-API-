package com.anhqv.characterservice.mapper;

import com.anhqv.characterservice.dto.CharacterPreviewDTO;
import com.anhqv.characterservice.dto.CharacterRequestDTO;
import com.anhqv.characterservice.dto.CharacterRequestUpdateDTO;
import com.anhqv.characterservice.dto.CharacterResponseDTO;
import com.anhqv.characterservice.model.CharacterEntity;
import org.springframework.stereotype.Component;

@Component
public class CharacterMapper {

    private CharacterMapper() {
    }

    public static CharacterEntity toEntity(CharacterRequestDTO request) {
        return new CharacterEntity(
                null, request.name(), request.firstSurname(), request.secondSurname(),
                request.description(), request.gender(), request.mainCharacter(),
                request.imageUrl(), request.dateOfBirth(), request.actorName(), true
        );
    }

    public static CharacterPreviewDTO toPreview(CharacterEntity entity) {
        return new CharacterPreviewDTO(
                entity.getId(), entity.getName(), entity.getFirstSurname(),
                entity.getImageUrl(), entity.getActorName()
        );
    }

    public static CharacterResponseDTO toResponse(CharacterEntity entity) {
        return new CharacterResponseDTO(
                entity.getId(), entity.getName(), entity.getFirstSurname(),
                entity.getSecondSurname(), entity.getDescription(), entity.getGender(),
                (entity.isMainCharacter() ? "Personaje principal" : "Personaje secundario"),
                entity.getImageUrl(), entity.getDateOfBirth(), entity.getActorName(),
                (entity.isActive() ? "Activo" : "Desactivado")
        );
    }

    public static void toEntityUpdate(CharacterEntity entity, CharacterRequestUpdateDTO dto) {
        if (dto.name() != null && !dto.name().equals(entity.getName())) {
            entity.setName(dto.name());
        }
        if (dto.firstSurname() != null && !dto.firstSurname().equals(entity.getFirstSurname())) {
            entity.setFirstSurname(dto.firstSurname());
        }
        if (dto.secondSurname() != null && !dto.secondSurname().equals(entity.getSecondSurname())) {
            entity.setSecondSurname(dto.secondSurname());
        }
        if (dto.description() != null && !dto.description().equals(entity.getDescription())) {
            entity.setDescription(dto.description());
        }
        if (dto.gender() != null && !dto.gender().equals(entity.getGender())) {
            entity.setGender(dto.gender());
        }
        if (dto.imageUrl() != null && !dto.imageUrl().equals(entity.getImageUrl())) {
            entity.setImageUrl(dto.imageUrl());
        }
        if (dto.dateOfBirth() != null && !dto.dateOfBirth().equals(entity.getDateOfBirth())) {
            entity.setDateOfBirth(dto.dateOfBirth());
        }
        if (dto.actorName() != null && !dto.actorName().equals(entity.getActorName())) {
            entity.setActorName(dto.actorName());
        }
        if (dto.mainCharacter() != entity.isMainCharacter()) {
            entity.setMainCharacter(dto.mainCharacter());
        }
    }

}
