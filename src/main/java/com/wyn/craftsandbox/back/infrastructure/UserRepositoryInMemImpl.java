package com.wyn.craftsandbox.back.infrastructure;

import com.wyn.craftsandbox.back.domain.User;
import com.wyn.craftsandbox.back.domain.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryInMemImpl implements UserRepository {
    private final List<User> users;
    private int nextUserId;

    public UserRepositoryInMemImpl() {
        this.nextUserId = 0;
        this.users = new ArrayList<>();
    }

    @Override
    public User[] allUsers() {
        return users.toArray(new User[0]);
    }

    @Override
    public User addUser(String firstName, String lastName) {
        User user = new User(nextUserId, firstName, lastName);
        users.add(user);
        nextUserId++;
        return user;
    }
}