package com.wyn.craftsandbox.back.infrastructure;

import com.wyn.craftsandbox.back.domain.User;
import com.wyn.craftsandbox.back.domain.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserRepositoryImplTest {
    private UserRepository repository;
    private JpaUserRepository jpaUserRepository;

    @BeforeEach
    public void beforeEach() {
        this.jpaUserRepository = mock(JpaUserRepository.class);
        this.repository = new UserRepositoryImpl(jpaUserRepository);
    }

    @Test
    void user_first_id_is_0() {
        assertThat(repository.getNextId()).isZero();
    }

    @Test
    void user_next_id_is_incremented_when_adding_a_new_user() {
        when(jpaUserRepository.save(any(JpaUser.class))).thenReturn(mock(JpaUser.class));

        User user = new User(0, "Chuck", "NORRIS");
        repository.saveUser(user);

        assertThat(repository.getNextId()).isEqualTo(1);
    }
}