package com.anhqv.characterservice.service;

import com.anhqv.characterservice.dto.CharacterPreviewDTO;
import com.anhqv.characterservice.dto.CharacterRequestDTO;
import com.anhqv.characterservice.dto.CharacterRequestUpdateDTO;
import com.anhqv.characterservice.dto.CharacterResponseDTO;
import com.anhqv.characterservice.exception.CharacterNotFoundException;

import java.util.List;

public interface CharacterService {

    /**
     * Crea un nuevo personaje en la base de datos.
     * @param requestDTO Los datos del personaje a crear.
     * @return El CharacterResponseDTO del personaje creado.
     */
    CharacterResponseDTO createCharacter(CharacterRequestDTO requestDTO);

    /**
     * Obtiene un personaje por su ID.
     * @param id El ID del personaje.
     * @return El CharacterResponseDTO del personaje encontrado.
     * @throws CharacterNotFoundException Si no se encuentra el personaje con el ID dado.
     */
    CharacterResponseDTO getCharacterById(Long id) throws CharacterNotFoundException;

    /**
     * Obtiene una lista de todos los personajes, en formato de vista previa.
     * @return Una lista de CharacterPreviewDTO.
     */
    List<CharacterPreviewDTO> getAllCharacters();

    /**
     * Actualiza un personaje existente por su ID.
     * @param id El ID del personaje a actualizar.
     * @param requestDTO Los datos actualizados del personaje.
     * @return El CharacterResponseDTO del personaje actualizado.
     * @throws CharacterNotFoundException Si no se encuentra el personaje con el ID dado.
     */
    CharacterResponseDTO updateCharacter(Long id, CharacterRequestUpdateDTO requestDTO) throws CharacterNotFoundException;

    /**
     * Elimina un personaje por su ID.
     * @param id El ID del personaje a eliminar.
     * @throws CharacterNotFoundException Si no se encuentra el personaje con el ID dado.
     */
    @Deprecated
    void deleteCharacter(Long id) throws CharacterNotFoundException;

    /**
     * Actualiza el estado de activación (activo/inactivo) de un personaje.
     *
     * @param id       El ID del personaje.
     * @param isActive El nuevo estado (true para activar, false para desactivar).
     * @return El CharacterResponseDTO del personaje con el estado actualizado.
     * @throws CharacterNotFoundException Si no se encuentra el personaje con el ID dado.
     */
    CharacterResponseDTO updateCharacterActivationStatus(Long id, boolean isActive) throws CharacterNotFoundException;

    /**
     * Obtiene una lista de todos los personajes activados.
     * @return Lista de CharacterPreviewDTO con personajes activos.
     */
    List<CharacterPreviewDTO> getAllActiveCharacters();

    /**
     * Obtiene un personaje activado por su ID.
     * @param id ID del personaje.
     * @return CharacterResponseDTO si está activado.
     * @throws CharacterNotFoundException Si no existe o no está activado.
     */
    CharacterResponseDTO getActiveCharacterById(Long id) throws CharacterNotFoundException;
}