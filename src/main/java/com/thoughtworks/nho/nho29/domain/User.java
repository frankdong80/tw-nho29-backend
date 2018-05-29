package com.thoughtworks.nho.nho29.domain;

import javax.security.auth.Subject;
import java.io.Serializable;
import java.security.Principal;


public class User implements Principal, Serializable{

    private Long id;

    private String username;

    private String password;

    public User() { }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getName() {
        return this.username;
    }

    @Override
    public boolean implies(Subject subject) {
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
