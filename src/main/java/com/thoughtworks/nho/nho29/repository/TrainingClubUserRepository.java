package com.thoughtworks.nho.nho29.repository;

import com.thoughtworks.nho.nho29.domain.TrainingClubUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingClubUserRepository extends CrudRepository<TrainingClubUser, Long> {
    TrainingClubUser findByUsername(String username);
}
