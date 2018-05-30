package com.thoughtworks.nho.nho29.service;

import com.thoughtworks.nho.nho29.domain.TrainingClub;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
public interface TrainingClubService {

    TrainingClub findTrainingClubById(Long id);

}
