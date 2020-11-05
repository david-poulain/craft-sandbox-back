package com.wyn.craftsandbox.back.infrastructure;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_id_generator", schema = "schema_wyn")
public class JpaUserIdGenerator {
    @Id
    private int id;
    private int nextGeneratedUserId;

    protected JpaUserIdGenerator() {
    }

    public JpaUserIdGenerator(int id, int nextGeneratedUserId) {
        this.id = id;
        this.nextGeneratedUserId = nextGeneratedUserId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNextGeneratedUserId() {
        return nextGeneratedUserId;
    }

    public void setNextGeneratedUserId(int nextGeneratedUserId) {
        this.nextGeneratedUserId = nextGeneratedUserId;
    }
}