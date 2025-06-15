package com.anhqv.apartmentservice.service;

import com.anhqv.apartmentservice.dto.occupancy.request.OccupancyRequestDTO;
import com.anhqv.apartmentservice.dto.occupancy.response.OccupancyResponseDTO;
import com.anhqv.apartmentservice.dto.character.response.CharacterPreviewDTO; // Necesario si OccupancyResponseDTO lo usa
import com.anhqv.apartmentservice.exception.ApartmentNotFoundException; // Si el apartmentId no existe para una ocupación
import com.anhqv.apartmentservice.exception.CharacterNotFoundException; // Si el characterId no existe
import com.anhqv.apartmentservice.exception.OccupancyConflictException;
import com.anhqv.apartmentservice.exception.OccupancyInvalidDataException;
import com.anhqv.apartmentservice.exception.OccupancyNotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface ApartmentOccupancyService {

    /**
     * Registra una nueva ocupación para un apartamento específico por un personaje.
     * Esta operación es la lógica central de gestión de ocupaciones. Se encarga de:
     * 1. Validar la existencia del apartamento y del personaje.
     * 2. Validar que la unidad sea habitable si la ocupación es residencial.
     * 3. Buscar y finalizar cualquier ocupación 'current' anterior para ese personaje (si se muda).
     * 4. Buscar y finalizar cualquier ocupación 'current' anterior para ese apartamento (si entra un nuevo ocupante principal).
     * 5. Crear la nueva entrada de ocupación y marcarla como 'current'.
     *
     * @param apartmentId El ID del apartamento que se va a ocupar.
     * @param occupancyRequestDTO Los datos de la nueva ocupación (characterId, startDate, endDate, occupancyType).
     * @return El DTO de respuesta de la ocupación creada.
     * @throws ApartmentNotFoundException Si el apartamento especificado por {@code apartmentId} no existe.
     * @throws CharacterNotFoundException Si el personaje referenciado por {@code characterId} en el DTO no existe en el CharacterService externo.
     * @throws OccupancyConflictException Si la unidad no es de tipo VIVIENDA y se intenta una ocupación de residencia (OWNER, TENANT, SQUATTER),
     * o si hay solapamientos de ocupaciones 'current' no permitidos que la lógica no pueda resolver automáticamente.
     * @throws OccupancyInvalidDataException Si los datos de la ocupación (fechas, tipos) son inconsistentes o inválidos (ej. {@code startDate} es futuro, {@code endDate} es anterior a {@code startDate}).
     */
    OccupancyResponseDTO registerNewOccupancy(Long apartmentId, OccupancyRequestDTO occupancyRequestDTO)
            throws ApartmentNotFoundException, CharacterNotFoundException, OccupancyConflictException, OccupancyInvalidDataException;

    /**
     * Obtiene el historial completo de ocupaciones para un apartamento específico.
     * La lista incluirá tanto las ocupaciones actuales como las históricas.
     *
     * @param apartmentId El ID interno del apartamento del cual se quiere obtener el historial.
     * @return Una lista de DTOs de respuesta de ocupaciones, enriquecidos con detalles básicos del personaje.
     * @throws ApartmentNotFoundException Si el apartamento no se encuentra con el ID dado.
     */
    List<OccupancyResponseDTO> getOccupancyHistoryByApartment(Long apartmentId) throws ApartmentNotFoundException;

    /**
     * Obtiene la ocupación actual activa de un personaje en cualquier apartamento.
     *
     * @param characterId El ID del personaje cuya ocupación actual se desea buscar.
     * @return El DTO de respuesta de la ocupación actual del personaje, si existe.
     * @throws CharacterNotFoundException Si el personaje no se encuentra (se verifica con el CharacterService).
     * @throws OccupancyNotFoundException Si el personaje existe pero no tiene ninguna ocupación actual activa.
     * @throws ApartmentNotFoundException Si la ocupación actual del personaje apunta a un apartamento inexistente (indicando inconsistencia de datos, un caso raro pero posible).
     */
    OccupancyResponseDTO getCurrentOccupancyByCharacter(Long characterId)
            throws CharacterNotFoundException, OccupancyNotFoundException, ApartmentNotFoundException;

    /**
     * Finaliza una ocupación actual de un personaje en un apartamento específico, estableciendo la fecha de fin.
     * Una vez finalizada, la ocupación deja de ser 'current'.
     *
     * @param apartmentId El ID del apartamento donde se finaliza la ocupación.
     * @param characterId El ID del personaje cuya ocupación se va a finalizar.
     * @param endDate La fecha en la que finaliza la ocupación. Esta fecha no debe ser nula para finalizar.
     * @return El DTO de respuesta de la ocupación actualizada con la fecha de fin.
     * @throws ApartmentNotFoundException Si el apartamento no se encuentra.
     * @throws CharacterNotFoundException Si el personaje no se encuentra.
     * @throws OccupancyNotFoundException Si no se encuentra una ocupación actual activa para el personaje en ese apartamento.
     * @throws OccupancyInvalidDataException Si la fecha de fin proporcionada es inválida (ej. anterior a la fecha de inicio, o futura para finalizar una ocupación pasada).
     */
    OccupancyResponseDTO endOccupancy(Long apartmentId, Long characterId, LocalDate endDate)
            throws ApartmentNotFoundException, CharacterNotFoundException, OccupancyNotFoundException, OccupancyInvalidDataException;

    // --- Métodos Adicionales del Dominio de Ocupación ---

    /**
     * Obtiene todo el historial de ocupaciones (actuales e históricas) para un personaje específico.
     * @param characterId El ID del personaje del cual se quiere obtener el historial de ocupaciones.
     * @return Una lista de DTOs de respuesta de ocupaciones para el personaje dado, incluyendo el apartamento y los detalles del personaje.
     * @throws CharacterNotFoundException Si el personaje no se encuentra (se verifica con el CharacterService).
     */
    List<OccupancyResponseDTO> getOccupanciesByCharacterId(Long characterId) throws CharacterNotFoundException;

    /**
     * Obtiene una lista de todas las ocupaciones actualmente activas para un apartamento específico.
     * @param apartmentId El ID del apartamento.
     * @return Una lista de DTOs de respuesta de ocupaciones que son 'current' para el apartamento dado.
     * @throws ApartmentNotFoundException Si el apartamento no se encuentra.
     */
    List<OccupancyResponseDTO> getCurrentOccupanciesByApartment(Long apartmentId) throws ApartmentNotFoundException;


    // void deleteOccupancyRecord(Long occupancyId); // No se pretende este metodo aun
}