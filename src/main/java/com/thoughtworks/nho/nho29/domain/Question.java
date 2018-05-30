package com.thoughtworks.nho.nho29.domain;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "question")
@Entity
@ToString
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "selection_a")
    private String selectionA;

    @Column(name = "selection_b")
    private String selectionB;

    @Column(name = "selection_c")
    private String selectionC;

    @Column(name = "selection_d")
    private String selectionD;

    @Column(name = "answer")
    private String answer;

    @Column(name = "test_paper_id")
    private Long testPaperId;
}
