package com.anhqv.characterservice.exception;

public class CharacterNotFoundException extends RuntimeException {

    public CharacterNotFoundException(Long id) {
        super("No se encontró el personaje con ID: " + id);
    }

    public CharacterNotFoundException(String message) {
        super(message);
    }
}