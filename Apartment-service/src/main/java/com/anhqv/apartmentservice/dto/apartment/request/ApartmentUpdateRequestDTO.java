package com.anhqv.apartmentservice.dto.apartment.request;

import com.anhqv.apartmentservice.model.PropertyType;

public record ApartmentUpdateRequestDTO(
        String unitIdentifier,
        PropertyType propertyType,
        String description,
        Double squareMeters
) {
}
