package com.anhqv.apartmentservice.exception;

public class OccupancyConflictException extends RuntimeException {
    public OccupancyConflictException(String message) {
        super(message);
    }
}
