package com.anhqv.characterservice.exception;

public class CharacterConflictException extends RuntimeException {

    public CharacterConflictException(String message) {
        super(message);
    }

    public CharacterConflictException(Long id, String message) {
        super("Conflicto con el personaje con ID " + id + ": " + message);
    }
}