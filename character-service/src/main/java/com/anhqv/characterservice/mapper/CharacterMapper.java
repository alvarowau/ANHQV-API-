package com.anhqv.characterservice.mapper;

import com.anhqv.characterservice.dto.CharacterPreviewDTO;
import com.anhqv.characterservice.dto.CharacterRequestDTO;
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
                request.imageUrl(), request.dateOfBirth(), request.actorName()
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
                entity.getImageUrl(), entity.getDateOfBirth(), entity.getActorName()
        );
    }
}
