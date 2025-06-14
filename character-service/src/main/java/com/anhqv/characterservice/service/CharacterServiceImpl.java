package com.anhqv.characterservice.service;

import com.anhqv.characterservice.dto.CharacterPreviewDTO;
import com.anhqv.characterservice.dto.CharacterRequestDTO;
import com.anhqv.characterservice.dto.CharacterResponseDTO;
import com.anhqv.characterservice.exception.CharacterNotFoundException;
import com.anhqv.characterservice.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository characterRepository;

    @Override
    public CharacterResponseDTO createCharacter(CharacterRequestDTO requestDTO) {
        return null;
    }

    @Override
    public CharacterResponseDTO getCharacterById(Long id) throws CharacterNotFoundException {
        return null;
    }

    @Override
    public List<CharacterPreviewDTO> getAllCharacters() {
        return List.of();
    }

    @Override
    public CharacterResponseDTO updateCharacter(Long id, CharacterRequestDTO requestDTO) throws CharacterNotFoundException {
        return null;
    }

    @Override
    public void deleteCharacter(Long id) throws CharacterNotFoundException {

    }
}
