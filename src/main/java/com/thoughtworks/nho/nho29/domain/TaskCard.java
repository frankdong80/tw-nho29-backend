package com.thoughtworks.nho.nho29.domain;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "task_card")
@Entity
@ToString
public class TaskCard {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "icon")
    private String icon;

    @Column(name = "trainingClubId")
    private Long trainingClubId;

    @Column(name = "testPaperId")
    private Long testPaperId;
}
