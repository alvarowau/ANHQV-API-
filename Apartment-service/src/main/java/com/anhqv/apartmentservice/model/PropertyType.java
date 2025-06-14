package com.anhqv.apartmentservice.model;

import lombok.Getter;

@Getter
public enum PropertyType {
    HOUSING("Unidad de vivienda residencial"),
    COMMERCIAL_SPACE("Espacio destinado a comercio o negocio"),
    COMMON_AREA("Áreas compartidas o comunitarias");


    private final String descripcion;

    PropertyType(String descripcion) {
        this.descripcion = descripcion;
    }

}
