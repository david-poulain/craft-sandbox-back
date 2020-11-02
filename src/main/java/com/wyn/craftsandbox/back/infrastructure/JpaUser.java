package com.wyn.craftsandbox.back.infrastructure;

import com.wyn.craftsandbox.back.domain.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "JpaUser")
@Table(name = "USERS", schema = "SCHEMA")
public class JpaUser {
    @Id
    private int id;
    private String firstName;
    private String lastName;

    protected JpaUser() {
    }

    public JpaUser(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
    }

    public User toUser() {
        return new User(id, firstName, lastName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
