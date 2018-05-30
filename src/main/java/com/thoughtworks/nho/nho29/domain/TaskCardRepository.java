package com.thoughtworks.nho.nho29.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskCardRepository extends JpaRepository<TaskCard,Long> {
    List<TaskCard> findAllByTrainingClubId(Long id);
}
