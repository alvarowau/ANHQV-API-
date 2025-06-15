package com.anhqv.apartmentservice.dto.occupancy;

import com.anhqv.apartmentservice.model.OccupancyType;

import java.time.LocalDate;

public record OccupancyResponseDTO(
        Long id, Long apartmentId, String character, LocalDate startDate,
        LocalDate endDate, OccupancyType occupancyType, String isCurrent
) {
}
