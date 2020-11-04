package com.wyn.craftsandbox.back.infrastructure;

import com.wyn.craftsandbox.back.domain.User;
import com.wyn.craftsandbox.back.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private int nextId = 0;
    private JpaUserRepository jpaUserRepository;

    @Autowired
    public UserRepositoryImpl(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public List<User> allUsers() {
        return jpaUserRepository.findAll().stream().map(JpaUser::toUser).collect(Collectors.toList());
    }

    @Override
    public int getNextId() {
        return nextId;
    }

    @Override
    public void saveUser(User user) {
        JpaUser jpaUser = new JpaUser(user);
        nextId++;
        jpaUserRepository.save(jpaUser).toUser();
    }

}
