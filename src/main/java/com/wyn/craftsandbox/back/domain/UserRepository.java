package com.wyn.craftsandbox.back.domain;

import java.util.List;

public interface UserRepository {
    List<User> allUsers();

    int getNextId();

    void saveUser(User user);
}
