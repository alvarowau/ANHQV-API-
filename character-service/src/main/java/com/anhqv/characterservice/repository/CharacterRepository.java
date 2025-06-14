package com.anhqv.characterservice.repository;

import com.anhqv.characterservice.model.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<CharacterEntity,Long> {
}
