package com.thoughtworks.nho.nho29.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
@EqualsAndHashCode(exclude = {"trainingClubUsers"})
@ToString(exclude = {"trainingClubUsers"})
@Entity
@Table(name = "training_club")
public class TrainingClub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "thumbnail_url")
    private String thumbnailUrl;

    @JsonIgnore
    @ManyToMany(mappedBy = "trainingClubs")
    private Set<TrainingClubUser> trainingClubUsers = new HashSet<>();



}
