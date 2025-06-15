package com.anhqv.apartmentservice.exception;

public class ApartmentNotFoundException extends RuntimeException {

  // Constructor principal: para cuando no se encuentra por su identificador (lo más común para Apartments)
  public ApartmentNotFoundException(String unitIdentifier) {
    super("No se encontró el apartamento con identificador: '" + unitIdentifier + "'");
  }

  // Constructor para cuando no se encuentra por ID (si tus repositorios o servicios también buscan por ID interno)
  public ApartmentNotFoundException(Long id) {
    super("No se encontró el apartamento con ID interno: " + id);
  }
}