package com.anhqv.apartmentservice.dto.apartment;

import com.anhqv.apartmentservice.model.PropertyType;

import java.util.List;

public record ApartmentResponseDTO(
        Long id, String unitIdentifier, PropertyType propertyType,
        String description, Double squareMeters, String isActive,
        List<String> characterOccupants
) {
}
