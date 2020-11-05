package com.wyn.craftsandbox.back.infrastructure;

import com.wyn.craftsandbox.back.domain.User;
import com.wyn.craftsandbox.back.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {
    public static final int USER_ID_GENERATOR_ID = 0;
    private final JpaUserIdGeneratorRepository jpaUserIdGeneratorRepository;
    private final JpaUserRepository jpaUserRepository;

    @Autowired
    public UserRepositoryImpl(JpaUserIdGeneratorRepository jpaUserIdGeneratorRepository, JpaUserRepository jpaUserRepository) {
        this.jpaUserIdGeneratorRepository = jpaUserIdGeneratorRepository;
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public List<User> allUsers() {
        return jpaUserRepository.findAll().stream().map(JpaUser::toUser).collect(Collectors.toList());
    }

    @Override
    public int getNextId() {
        Optional<JpaUserIdGenerator> jpaUserIdGeneratorOptional = jpaUserIdGeneratorRepository.findById(USER_ID_GENERATOR_ID);
        if (jpaUserIdGeneratorOptional.isEmpty()) {
            throw new UserIdGeneratorNotFoundException(USER_ID_GENERATOR_ID);
        }
        return jpaUserIdGeneratorOptional.get().getNextGeneratedUserId();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        jpaUserIdGeneratorRepository.updateNextGeneratedUserId(USER_ID_GENERATOR_ID, getNextId() + 1);
        jpaUserRepository.save(new JpaUser(user)).toUser();
    }
}
