package com.wyn.craftsandbox.back.infrastructure;

import com.wyn.craftsandbox.back.domain.User;
import com.wyn.craftsandbox.back.domain.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ActiveProfiles("h2-local")
class UserRepositoryIT {
    @Autowired
    private UserRepository repository;

    @Test
    void user_next_id_is_incremented_when_adding_a_new_user() {
        int nextId = repository.getNextId();

        User user = new User(nextId, "James", "Bond");
        repository.saveUser(user);

        assertThat(repository.getNextId()).isEqualTo(nextId + 1);
    }
}