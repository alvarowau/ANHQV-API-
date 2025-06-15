package com.anhqv.apartmentservice.dto.apartment;

import com.anhqv.apartmentservice.model.PropertyType;

public record ApartmentRequestDTO (
        String unitIdentifier,
        PropertyType propertyType,
        String description,
        Double squareMeters
){
}
