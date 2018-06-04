package com.thoughtworks.nho.nho29.service.impl;

import com.thoughtworks.nho.nho29.domain.TrainingClub;
import com.thoughtworks.nho.nho29.domain.TrainingClubUser;
import com.thoughtworks.nho.nho29.repository.TrainingClubUserRepository;
import com.thoughtworks.nho.nho29.service.TrainingClubUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class TrainingClubUserServiceImpl implements TrainingClubUserService {

    @Autowired
    private TrainingClubUserRepository trainingClubUserRepository;

    @Override
    public TrainingClubUser findByUsername(String username) {
        return this.trainingClubUserRepository.findByUsername(username);
    }

    @Override
    public TrainingClubUser findOne(Long id) {
        return this.trainingClubUserRepository.findById(id).orElse(new TrainingClubUser(-1L,"Unknown",""));
    }
}
