package com.wyn.craftsandbox.back.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserIdGeneratorRepository extends JpaRepository<JpaUserIdGenerator, Integer> {
    @Modifying
    @Query("update JpaUserIdGenerator set nextGeneratedUserId = :next_generated_user_id where id = :id")
    void updateNextGeneratedUserId(@Param("id") int id, @Param("next_generated_user_id") int nextGeneratedUserId);
}
