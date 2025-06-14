package com.anhqv.characterservice.service;

import com.anhqv.characterservice.dto.CharacterPreviewDTO;
import com.anhqv.characterservice.dto.CharacterRequestDTO;
import com.anhqv.characterservice.dto.CharacterRequestUpdateDTO;
import com.anhqv.characterservice.dto.CharacterResponseDTO;
import com.anhqv.characterservice.exception.CharacterConflictException;
import com.anhqv.characterservice.exception.CharacterNotFoundException;
import com.anhqv.characterservice.mapper.CharacterMapper;
import com.anhqv.characterservice.model.CharacterEntity;
import com.anhqv.characterservice.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository characterRepository;

    @Override
    public CharacterResponseDTO createCharacter(CharacterRequestDTO requestDTO) {
        return CharacterMapper
                .toResponse(characterRepository
                        .save(CharacterMapper
                                .toEntity(requestDTO)));

    }

    @Override
    public CharacterResponseDTO getCharacterById(Long id) throws CharacterNotFoundException {
        return CharacterMapper
                .toResponse(characterRepository
                        .findById(id)
                        .orElseThrow(() -> new CharacterNotFoundException("Character with id " + id + " not found")));
    }

    @Override
    public List<CharacterPreviewDTO> getAllCharacters() {
        return characterRepository
                .findAll()
                .stream()
                .map(CharacterMapper::toPreview)
                .toList();
    }

    @Override
    public CharacterResponseDTO updateCharacter(Long id, CharacterRequestUpdateDTO requestDTO) throws CharacterNotFoundException {
        CharacterEntity entity = characterRepository.findById(id)
                .orElseThrow(() -> new CharacterNotFoundException("Character with id " + id + " not found"));

        CharacterMapper.toEntityUpdate(entity, requestDTO);
        CharacterEntity updatedEntity = characterRepository.save(entity);
        return CharacterMapper.toResponse(updatedEntity);
    }


    @Override
    @Deprecated
    public void deleteCharacter(Long id) throws CharacterNotFoundException {
        Optional<CharacterEntity> characterEntity = characterRepository.findByIdAndIsActiveTrue(id);
        if (characterEntity.isEmpty()) {
            throw new CharacterNotFoundException("El character no existe o esta eliminado");
        }
        CharacterEntity entity = characterEntity.get();
        entity.setActive(false);
        characterRepository.save(entity);
    }

    @Override
    public CharacterResponseDTO updateCharacterActivationStatus(Long id, boolean isActive) throws CharacterNotFoundException, CharacterConflictException {
        CharacterEntity entity = characterRepository.findById(id)
                .orElseThrow(() -> new CharacterNotFoundException("No se encontró el personaje con ID: " + id));

        if (entity.isActive() == isActive) {
            String message = isActive ?
                    "El personaje con ID " + id + " ya está activo." :
                    "El personaje con ID " + id + " ya está desactivado.";
            throw new CharacterConflictException(id, message);
        }

        entity.setActive(isActive);
        CharacterEntity updatedEntity = characterRepository.save(entity);
        return CharacterMapper.toResponse(updatedEntity);
    }

    @Override
    public List<CharacterPreviewDTO> getAllActiveCharacters() {
        return characterRepository
                .findAllByIsActiveTrue()
                .stream()
                .map(CharacterMapper::toPreview)
                .toList();
    }

    @Override
    public CharacterResponseDTO getActiveCharacterById(Long id) throws CharacterNotFoundException {
        return CharacterMapper
                .toResponse(characterRepository
                        .findByIdAndIsActiveTrue(id)
                        .orElseThrow(() -> new CharacterNotFoundException("Character with id " + id + " not found")));
    }
}
