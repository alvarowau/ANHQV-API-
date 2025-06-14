package com.anhqv.characterservice.exception;

import com.anhqv.characterservice.error.ApiError;
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