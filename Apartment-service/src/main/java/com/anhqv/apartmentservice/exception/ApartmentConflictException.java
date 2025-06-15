package com.anhqv.apartmentservice.exception;

public class ApartmentConflictException extends RuntimeException {
    public ApartmentConflictException(String message) {
        super(message);
    }
}
