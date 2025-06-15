package com.anhqv.apartmentservice.dto.apartment.response;

import com.anhqv.apartmentservice.dto.character.response.CharacterPreviewDTO;
import com.anhqv.apartmentservice.model.PropertyType;

import java.util.List;

public record ApartmentResponseDTO(
        Long id, String unitIdentifier, PropertyType propertyType,
        String description, Double squareMeters, String isActive,
        List<CharacterPreviewDTO> characterOccupants
) {
}
