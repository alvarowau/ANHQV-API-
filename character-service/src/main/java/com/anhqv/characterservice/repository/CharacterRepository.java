package com.anhqv.characterservice.repository;

import com.anhqv.characterservice.model.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CharacterRepository extends JpaRepository<CharacterEntity,Long> {
    List<CharacterEntity> findAllByIsActiveTrue();
    Optional<CharacterEntity> findByIdAndIsActiveTrue(Long id);
}
