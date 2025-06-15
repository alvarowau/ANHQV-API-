package com.anhqv.apartmentservice.service.impl;

import com.anhqv.apartmentservice.dto.occupancy.request.OccupancyRequestDTO;
import com.anhqv.apartmentservice.dto.occupancy.response.OccupancyResponseDTO;
import com.anhqv.apartmentservice.exception.*;
import com.anhqv.apartmentservice.service.ApartmentOccupancyService;

import java.time.LocalDate;
import java.util.List;

public class ApartmentOccupancyServiceImpl implements ApartmentOccupancyService {
    @Override
    public OccupancyResponseDTO registerNewOccupancy(Long apartmentId, OccupancyRequestDTO occupancyRequestDTO) throws ApartmentNotFoundException, CharacterNotFoundException, OccupancyConflictException, OccupancyInvalidDataException {
        return null;
    }

    @Override
    public List<OccupancyResponseDTO> getOccupancyHistoryByApartment(Long apartmentId) throws ApartmentNotFoundException {
        return List.of();
    }

    @Override
    public OccupancyResponseDTO getCurrentOccupancyByCharacter(Long characterId) throws CharacterNotFoundException, OccupancyNotFoundException, ApartmentNotFoundException {
        return null;
    }

    @Override
    public OccupancyResponseDTO endOccupancy(Long apartmentId, Long characterId, LocalDate endDate) throws ApartmentNotFoundException, CharacterNotFoundException, OccupancyNotFoundException, OccupancyInvalidDataException {
        return null;
    }

    @Override
    public List<OccupancyResponseDTO> getOccupanciesByCharacterId(Long characterId) throws CharacterNotFoundException {
        return List.of();
    }

    @Override
    public List<OccupancyResponseDTO> getCurrentOccupanciesByApartment(Long apartmentId) throws ApartmentNotFoundException {
        return List.of();
    }
}
