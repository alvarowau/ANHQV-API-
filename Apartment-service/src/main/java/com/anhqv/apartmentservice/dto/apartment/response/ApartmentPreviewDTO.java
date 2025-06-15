package com.anhqv.apartmentservice.dto.apartment;

import com.anhqv.apartmentservice.model.PropertyType;

public record ApartmentPreviewDTO(
        Long id, String unitIdentifier,
        PropertyType propertyType, Integer currentOccupantsCount
) {
}
