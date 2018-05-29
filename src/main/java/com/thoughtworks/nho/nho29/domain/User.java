package com.thoughtworks.nho.nho29.domain;

import lombok.*;

import javax.persistence.*;
import javax.security.auth.Subject;
import java.io.Serializable;
import java.security.Principal;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "nho_user")
@Entity
@ToString
public class User implements Principal, Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    public User(String username, String password){
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

}
