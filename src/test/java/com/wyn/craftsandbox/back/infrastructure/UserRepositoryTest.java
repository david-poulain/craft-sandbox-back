package com.wyn.craftsandbox.back.infrastructure;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserRepositoryTest {
    @Test
    void throw_user_id_generator_not_found_exception_when_generator_is_not_in_the_database() {
        JpaUserIdGeneratorRepository jpaUserIdGeneratorRepository = mock(JpaUserIdGeneratorRepository.class);
        when(jpaUserIdGeneratorRepository.findById(0)).thenReturn(Optional.empty());

        JpaUserRepository jpaUserRepository = mock(JpaUserRepository.class);

        UserRepositoryImpl repository = new UserRepositoryImpl(jpaUserIdGeneratorRepository, jpaUserRepository);

        assertThatThrownBy(repository::getNextId).isInstanceOf(UserIdGeneratorNotFoundException.class);
    }
}