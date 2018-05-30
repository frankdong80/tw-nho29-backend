package com.thoughtworks.nho.nho29.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.security.Principal;
import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
@Data
@Table(name = "training_club_user")
@Entity
@EqualsAndHashCode(exclude = {"trainingClubs"})
@ToString(exclude = {"trainingClubs"})
public class TrainingClubUser implements Principal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    public TrainingClubUser(Long id,String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "training_club_user_clubs",
            joinColumns = {
                @JoinColumn(name = "training_club_user_id")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "training_club_id")
            }
    )
    private Set<TrainingClub> trainingClubs = new HashSet<>();

    @Override
    public String getName() {
        return this.username;
    }
}
