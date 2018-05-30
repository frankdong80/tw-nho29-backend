package com.thoughtworks.nho.nho29.service.impl;

import com.thoughtworks.nho.nho29.domain.TrainingClub;
import com.thoughtworks.nho.nho29.repository.TrainingClubRepository;
import com.thoughtworks.nho.nho29.service.TrainingClubService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class TrainingCludServiceImpl implements TrainingClubService {

    private TrainingClubRepository trainingClubRepository;

    @Override
    public TrainingClub findTrainingClubById(Long id) {
        return this.trainingClubRepository.findById(id).get();
    }
}
