package com.anhqv.apartmentservice.dto.occupancy.request;

import com.anhqv.apartmentservice.model.OccupancyType;

import java.time.LocalDate;

public record OccupancyRequestDTO(
        Long characterId, LocalDate startDate, LocalDate endDate,
        OccupancyType occupancyType
) {
}
