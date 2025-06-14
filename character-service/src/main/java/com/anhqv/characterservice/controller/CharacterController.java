package com.anhqv.characterservice.controller;

import com.anhqv.characterservice.dto.CharacterPreviewDTO;
import com.anhqv.characterservice.dto.CharacterRequestDTO;
import com.anhqv.characterservice.dto.CharacterRequestUpdateDTO;
import com.anhqv.characterservice.dto.CharacterResponseDTO;
import com.anhqv.characterservice.service.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/v1/characters")
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterService characterService;

    /**
     * POST /api/v1/characters
     * Crea un nuevo personaje.
     * @param requestDTO Los datos del personaje a crear.
     * @return ResponseEntity con el CharacterResponseDTO del personaje creado y HttpStatus.CREATED (201).
     */
    @PostMapping
    public ResponseEntity<CharacterResponseDTO> createCharacter(@Valid @RequestBody CharacterRequestDTO requestDTO) {
        return null;
    }

    /**
     * GET /api/v1/characters/{id}
     * Obtiene los detalles completos de un personaje por su ID.
     * @param id El ID del personaje.
     * @return ResponseEntity con el CharacterResponseDTO y HttpStatus.OK (200).
     */
    @GetMapping("/{id}")
    public ResponseEntity<CharacterResponseDTO> getCharacterById(@PathVariable Long id) {
        return null;
    }

    /**
     * GET /api/v1/characters
     * Obtiene una lista de todos los personajes (activos e inactivos) en formato de vista previa.
     * @return ResponseEntity con una lista de CharacterPreviewDTO y HttpStatus.OK (200).
     */
    @GetMapping
    public ResponseEntity<List<CharacterPreviewDTO>> getAllCharacters() {
        return null;
    }

    /**
     * GET /api/v1/characters/active
     * Obtiene una lista de todos los personajes que están activos, en formato de vista previa.
     * @return ResponseEntity con una lista de CharacterPreviewDTO y HttpStatus.OK (200).
     */
    @GetMapping("/active")
    public ResponseEntity<List<CharacterPreviewDTO>> getAllActiveCharacters() {
        return null;
    }

    /**
     * GET /api/v1/characters/active/{id}
     * Obtiene los detalles completos de un personaje ACTIVO por su ID.
     * @param id El ID del personaje activo.
     * @return ResponseEntity con el CharacterResponseDTO y HttpStatus.OK (200).
     */
    @GetMapping("/active/{id}")
    public ResponseEntity<CharacterResponseDTO> getActiveCharacterById(@PathVariable Long id) {
        return null;
    }

    /**
     * PUT /api/v1/characters/{id}
     * Actualiza los datos de un personaje existente.
     * @param id El ID del personaje a actualizar.
     * @param requestDTO Los datos actualizados del personaje.
     * @return ResponseEntity con el CharacterResponseDTO del personaje actualizado y HttpStatus.OK (200).
     */
    @PutMapping("/{id}")
    public ResponseEntity<CharacterResponseDTO> updateCharacter(@PathVariable Long id, @Valid @RequestBody CharacterRequestUpdateDTO requestDTO) {
        return null;
    }

    /**
     * DELETE /api/v1/characters/{id}
     * Desactiva lógicamente un personaje por su ID.
     * @param id El ID del personaje a desactivar.
     * @return ResponseEntity con HttpStatus.NO_CONTENT (204).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deactivateCharacter(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }

    /**
     * PUT /api/v1/characters/{id}/activate
     * Activa un personaje lógicamente por su ID.
     * @param id El ID del personaje a activar.
     * @return ResponseEntity con el CharacterResponseDTO del personaje activado y HttpStatus.OK (200).
     */
    @PutMapping("/{id}/activate")
    public ResponseEntity<CharacterResponseDTO> activateCharacter(@PathVariable Long id) {
        return null;
    }
}