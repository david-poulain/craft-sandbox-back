package com.wyn.craftsandbox.back.infrastructure;

public class UserIdGeneratorNotFoundException extends RuntimeException {
    public UserIdGeneratorNotFoundException(int generatorId) {
        super(String.format("User Id Generator %d is not in the database.", generatorId));
    }
}
