package com.anhqv.apartmentservice.exception;

import com.anhqv.apartmentservice.error.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja la excepción ApartmentNotFoundException y devuelve un 404 Not Found.
     */
    @ExceptionHandler(ApartmentNotFoundException.class)
    public ResponseEntity<ApiError> handleApartmentNotFoundException(
            ApartmentNotFoundException ex, WebRequest request) {

        List<String> details = List.of(ex.getMessage());

        return createResponse(
                request,
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                details
        );
    }

    /**
     * Maneja la excepción CharacterNotFoundException (cuando es lanzada por ApartmentService)
     * y devuelve un 404 Not Found.
     */
    @ExceptionHandler(CharacterNotFoundException.class)
    public ResponseEntity<ApiError> handleCharacterNotFoundException(
            CharacterNotFoundException ex, WebRequest request) {

        List<String> details = List.of(ex.getMessage());

        return createResponse(
                request,
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                details
        );
    }

    /**
     * Maneja la excepción ApartmentConflictException y devuelve un 409 Conflict.
     */
    @ExceptionHandler(ApartmentConflictException.class)
    public ResponseEntity<ApiError> handleApartmentConflictException(
            ApartmentConflictException ex, WebRequest request) {

        List<String> details = List.of(ex.getMessage());

        return createResponse(
                request,
                HttpStatus.CONFLICT,
                ex.getMessage(),
                details
        );
    }

    /**
     * Maneja la excepción OccupancyConflictException y devuelve un 409 Conflict.
     */
    @ExceptionHandler(OccupancyConflictException.class)
    public ResponseEntity<ApiError> handleOccupancyConflictException(
            OccupancyConflictException ex, WebRequest request) {

        List<String> details = List.of(ex.getMessage());

        return createResponse(
                request,
                HttpStatus.CONFLICT,
                ex.getMessage(),
                details
        );
    }

    /**
     * Maneja la excepción OccupancyNotFoundException y devuelve un 404 Not Found.
     */
    @ExceptionHandler(OccupancyNotFoundException.class)
    public ResponseEntity<ApiError> handleOccupancyNotFoundException(
            OccupancyNotFoundException ex, WebRequest request) {

        List<String> details = List.of(ex.getMessage());

        return createResponse(
                request,
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                details
        );
    }

    /**
     * Maneja la excepción OccupancyInvalidDataException y devuelve un 400 Bad Request.
     */
    @ExceptionHandler(OccupancyInvalidDataException.class)
    public ResponseEntity<ApiError> handleOccupancyInvalidDataException(
            OccupancyInvalidDataException ex, WebRequest request) {

        List<String> details = List.of(ex.getMessage());

        return createResponse(
                request,
                HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                details
        );
    }


    /**
     * Maneja las excepciones de validación de argumentos (@Valid en DTOs)
     * y devuelve un 400 Bad Request con detalles de los errores.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, WebRequest request) {

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .collect(Collectors.toList());

        return createResponse(
                request,
                HttpStatus.BAD_REQUEST,
                "Error de validación de entrada.",
                errors
        );
    }

    /**
     * Maneja cualquier otra excepción no capturada y devuelve un 500 Internal Server Error.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGenericException(
            Exception ex, WebRequest request) {

        List<String> details = List.of(ex.getMessage() != null ? ex.getMessage() : "Error desconocido");

        return createResponse(
                request,
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Ha ocurrido un error inesperado. Por favor, inténtelo de nuevo más tarde.",
                details
        );
    }

    /**
     * Método auxiliar para construir una respuesta ApiError estandarizada.
     * Es crucial que WebRequest se pueda castear a ServletWebRequest para obtener la URI.
     */
    private ResponseEntity<ApiError> createResponse(WebRequest request, HttpStatus status, String message, List<String> details) {
        String path = "";
        if (request instanceof ServletWebRequest) {
            path = ((ServletWebRequest) request).getRequest().getRequestURI();
        }

        ApiError apiError = ApiError.builder()
                .timestamp(LocalDateTime.now())
                .status(status.value())
                .error(status.getReasonPhrase())
                .message(message)
                .path(path)
                .details(details)
                .build();

        return new ResponseEntity<>(apiError, status);
    }
}