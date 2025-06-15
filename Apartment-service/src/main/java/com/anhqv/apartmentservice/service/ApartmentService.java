package com.anhqv.apartmentservice.service;

import com.anhqv.apartmentservice.dto.apartment.request.ApartmentRequestDTO;
import com.anhqv.apartmentservice.dto.apartment.request.ApartmentUpdateRequestDTO;
import com.anhqv.apartmentservice.dto.apartment.response.ApartmentPreviewDTO;
import com.anhqv.apartmentservice.dto.apartment.response.ApartmentResponseDTO;
import com.anhqv.apartmentservice.exception.ApartmentNotFoundException;
import com.anhqv.apartmentservice.exception.ApartmentConflictException;
import com.anhqv.apartmentservice.model.PropertyType; // Necesario para getApartmentsByPropertyType

import java.util.List;

public interface ApartmentService {

    /**
     * Crea un nuevo apartamento o local en el sistema.
     * Al crear, la unidad se considera activa por defecto.
     *
     * @param requestDTO Los datos del apartamento a crear.
     * @return El DTO de respuesta del apartamento creado, incluyendo su ID y estado inicial.
     * @throws ApartmentConflictException Si ya existe un apartamento con el mismo unitIdentifier.
     */
    ApartmentResponseDTO createApartment(ApartmentRequestDTO requestDTO) throws ApartmentConflictException; // Añadida excepción por unicidad

    /**
     * Obtiene los detalles completos de un apartamento por su identificador único (ej. "3A", "Videoclub").
     * @param unitIdentifier El identificador único del apartamento a buscar.
     * @return El DTO de respuesta detallado del apartamento.
     * @throws ApartmentNotFoundException Si no se encuentra ningún apartamento con el identificador proporcionado.
     */
    ApartmentResponseDTO getApartmentByIdentifier(String unitIdentifier) throws ApartmentNotFoundException;

    /**
     * Obtiene una lista de todos los apartamentos y locales registrados en el sistema,
     * tanto activos como inactivos, en formato de vista previa.
     * @return Una lista de DTOs de vista previa de apartamentos.
     */
    List<ApartmentPreviewDTO> getAllApartments();

    /**
     * Obtiene una lista de todos los apartamentos y locales que están actualmente activos en el sistema,
     * en formato de vista previa.
     * @return Una lista de DTOs de vista previa de apartamentos activos.
     */
    List<ApartmentPreviewDTO> getAllActiveApartments();


    /**
     * Actualiza los datos de un apartamento existente identificado por su identificador único.
     * Permite actualizaciones parciales: solo los campos presentes en el requestDTO serán modificados.
     * @param unitIdentifier El identificador único del apartamento a actualizar.
     * @param requestDTO Los datos actualizados del apartamento. Los campos no nulos en este DTO serán aplicados.
     * @return El DTO de respuesta del apartamento actualizado.
     * @throws ApartmentNotFoundException Si el apartamento no se encuentra con el identificador dado.
     * @throws ApartmentConflictException Si la actualización genera un conflicto (ej. se intenta cambiar el unitIdentifier a uno que ya existe y está activo).
     */
    ApartmentResponseDTO updateApartment(String unitIdentifier, ApartmentUpdateRequestDTO requestDTO) throws ApartmentNotFoundException, ApartmentConflictException;

    /**
     * Actualiza el estado de activación (activo/inactivo) de un apartamento o local por su identificador único.
     * Este método gestiona la "eliminación lógica" (desactivación) y la reactivación de una unidad.
     * @param unitIdentifier El identificador único del apartamento cuyo estado se va a actualizar.
     * @param isActive El nuevo estado de activación ({@code true} para activar, {@code false} para desactivar).
     * @return El DTO de respuesta del apartamento con su estado de activación actualizado.
     * @throws ApartmentNotFoundException Si el apartamento no se encuentra con el identificador dado.
     * @throws ApartmentConflictException Si el apartamento ya está en el estado de activación deseado (ej. intentar desactivar un apartamento ya inactivo).
     */
    ApartmentResponseDTO updateApartmentActivationStatus(String unitIdentifier, boolean isActive) throws ApartmentNotFoundException, ApartmentConflictException;

    /**
     * Obtiene una lista de apartamentos o locales filtrados por su tipo de propiedad.
     * @param type El tipo de propiedad por el cual filtrar (VIVIENDA, LOCAL_COMERCIAL, COMMON_AREA).
     * @return Una lista de DTOs de vista previa de apartamentos que coinciden con el tipo especificado.
     */
    List<ApartmentPreviewDTO> getApartmentsByPropertyType(PropertyType type);

    /**
     * Obtiene una lista de todos los apartamentos que tienen al menos un ocupante activo actualmente.
     * Para determinar esto, este servicio consultará al ApartmentOccupancyService.
     * @return Una lista de DTOs de vista previa de los apartamentos ocupados actualmente.
     */
    List<ApartmentPreviewDTO> getOccupiedApartments();

}