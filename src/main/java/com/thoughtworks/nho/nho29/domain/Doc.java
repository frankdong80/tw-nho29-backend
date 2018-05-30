package com.thoughtworks.nho.nho29.domain;


import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "doc")
@Entity
@ToString
public class Doc {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="descirption")
    private String description;

    @Column(name="type")
    private String type;

    @Column(name="taskCardId")
    private Long taskCardId;

}
