package com.anhqv.apartmentservice.service.impl;

import com.anhqv.apartmentservice.dto.apartment.request.ApartmentRequestDTO;
import com.anhqv.apartmentservice.dto.apartment.request.ApartmentUpdateRequestDTO;
import com.anhqv.apartmentservice.dto.apartment.response.ApartmentPreviewDTO;
import com.anhqv.apartmentservice.dto.apartment.response.ApartmentResponseDTO;
import com.anhqv.apartmentservice.exception.ApartmentConflictException;
import com.anhqv.apartmentservice.exception.ApartmentNotFoundException;
import com.anhqv.apartmentservice.model.PropertyType;
import com.anhqv.apartmentservice.service.ApartmentService;

import java.util.List;

public class ApartmentServiceImpl implements ApartmentService {
    @Override
    public ApartmentResponseDTO createApartment(ApartmentRequestDTO requestDTO) throws ApartmentConflictException {
        return null;
    }

    @Override
    public ApartmentResponseDTO getApartmentByIdentifier(String unitIdentifier) throws ApartmentNotFoundException {
        return null;
    }

    @Override
    public List<ApartmentPreviewDTO> getAllApartments() {
        return List.of();
    }

    @Override
    public List<ApartmentPreviewDTO> getAllActiveApartments() {
        return List.of();
    }

    @Override
    public ApartmentResponseDTO updateApartment(String unitIdentifier, ApartmentUpdateRequestDTO requestDTO) throws ApartmentNotFoundException, ApartmentConflictException {
        return null;
    }

    @Override
    public ApartmentResponseDTO updateApartmentActivationStatus(String unitIdentifier, boolean isActive) throws ApartmentNotFoundException, ApartmentConflictException {
        return null;
    }

    @Override
    public List<ApartmentPreviewDTO> getApartmentsByPropertyType(PropertyType type) {
        return List.of();
    }

    @Override
    public List<ApartmentPreviewDTO> getOccupiedApartments() {
        return List.of();
    }
}
