package com.anhqv.apartmentservice.model;

import lombok.Getter;

@Getter
public enum OccupancyType {
    OWNER("Propietario del inmueble"),
    TENANT("Persona que alquila el inmueble"),
    SQUATTER("Persona que ocupa sin permiso"),
    GUEST("Ocupante temporal con permiso"),
    MANAGER("Administrador o encargado del inmueble"),
    UNKNOWN("Tipo de ocupación desconocido o no especificado");


    private final String description;

    OccupancyType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        String lower = name().toLowerCase();
        return Character.toUpperCase(lower.charAt(0)) + lower.substring(1);
    }
}