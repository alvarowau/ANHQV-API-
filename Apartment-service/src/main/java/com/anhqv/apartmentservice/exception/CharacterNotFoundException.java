package com.anhqv.apartmentservice.exception;

public class CharacterNotFoundException extends RuntimeException {
    public CharacterNotFoundException(Long characterId) {
        super("No se encontró el personaje con ID: " + characterId + " referenciado para esta operación.");
    }
    public CharacterNotFoundException(String message) { // Mantenemos el genérico por si hay otros casos
        super(message);
    }
}