package com.anhqv.apartmentservice.dto.occupancy.response;

import com.anhqv.apartmentservice.dto.character.response.CharacterPreviewDTO;
import com.anhqv.apartmentservice.model.OccupancyType;

import java.time.LocalDate;

public record OccupancyResponseDTO(
        Long id, Long apartmentId, CharacterPreviewDTO character, LocalDate startDate,
        LocalDate endDate, OccupancyType occupancyType, String isCurrent
) {
}
