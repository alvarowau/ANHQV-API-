package com.anhqv.characterservice.model;

public enum Gender {

    MALE,

    FEMALE,

    UNKNOWN;

    @Override
    public String toString() {
        return name().toLowerCase();
    }


    public static Gender fromString(String value) {
        if (value == null) {
            return UNKNOWN;
        }
        return switch (value.trim().toLowerCase()) {
            case "male" -> MALE;
            case "female" -> FEMALE;
            default -> UNKNOWN;
        };
    }
}
