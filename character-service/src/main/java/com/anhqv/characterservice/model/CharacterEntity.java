package com.anhqv.characterservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "characters")
public class CharacterEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String firstSurname;

    @Column(nullable = true, length = 100)
    private String secondSurname;

    @Column(nullable = true, length = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private boolean mainCharacter;

    @Column(nullable = true, length = 2048)
    private String imageUrl;

    @Column(nullable = true)
    private LocalDate dateOfBirth;

    @Column(nullable = true, length = 200)
    private String actorName;

    private boolean isActive;

}