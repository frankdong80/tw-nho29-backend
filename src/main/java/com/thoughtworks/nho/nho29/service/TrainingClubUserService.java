package com.thoughtworks.nho.nho29.service;

import com.thoughtworks.nho.nho29.domain.TrainingClubUser;

public interface TrainingClubUserService {
    TrainingClubUser findByUsername(String username);
    TrainingClubUser findOne(Long id);
}
