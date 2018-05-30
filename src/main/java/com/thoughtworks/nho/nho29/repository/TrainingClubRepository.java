package com.thoughtworks.nho.nho29.repository;

import com.thoughtworks.nho.nho29.domain.TrainingClub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TrainingClubRepository extends JpaRepository<TrainingClub, Long> {

}
