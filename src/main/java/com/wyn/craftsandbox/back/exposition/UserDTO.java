package com.wyn.craftsandbox.back.exposition;

public class UserDTO {
    private final String firstName;
    private final String lastName;

    public UserDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
