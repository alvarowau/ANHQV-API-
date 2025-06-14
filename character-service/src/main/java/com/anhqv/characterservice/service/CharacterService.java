package com.anhqv.characterservice.service;

import com.anhqv.characterservice.dto.CharacterRequestDTO;
import com.anhqv.characterservice.dto.CharacterResponseDTO;
import com.anhqv.characterservice.dto.CharacterPreviewDTO;
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
    CharacterResponseDTO updateCharacter(Long id, CharacterRequestDTO requestDTO) throws CharacterNotFoundException;

    /**
     * Elimina un personaje por su ID.
     * @param id El ID del personaje a eliminar.
     * @throws CharacterNotFoundException Si no se encuentra el personaje con el ID dado.
     */
    void deleteCharacter(Long id) throws CharacterNotFoundException;

    // Métodos adicionales que podríamos considerar más adelante si son necesarios para el MVP o versiones futuras:
    // List<CharacterPreviewDTO> searchCharacters(String name, String surname); // Para búsqueda por nombre/apellido
    // Long countCharacters(); // Para saber el número total de personajes
}