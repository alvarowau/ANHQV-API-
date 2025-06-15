package com.anhqv.apartmentservice.exception;

public class OccupancyNotFoundException extends RuntimeException {
    public OccupancyNotFoundException(Long occupancyId) { // Si se busca por ID de la ocupación
        super("No se encontró el registro de ocupación con ID: " + occupancyId);
    }
    public OccupancyNotFoundException(Long apartmentId, Long characterId) { // Si se busca una ocupación específica
        super("No se encontró una ocupación activa para el apartamento ID " + apartmentId + " y personaje ID " + characterId);
    }
    public OccupancyNotFoundException(String message) { // Para casos más genéricos
        super(message);
    }
}