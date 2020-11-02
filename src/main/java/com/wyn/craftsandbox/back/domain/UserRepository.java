package com.wyn.craftsandbox.back.domain;

public interface UserRepository {
    User[] allUsers();

    User addUser(String firstName, String lastName);
}
