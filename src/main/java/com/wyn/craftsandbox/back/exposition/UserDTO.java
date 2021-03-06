package com.wyn.craftsandbox.back.exposition;

public class UserDTO {
    private final int id;
    private final String firstName;
    private final String lastName;

    public UserDTO(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
