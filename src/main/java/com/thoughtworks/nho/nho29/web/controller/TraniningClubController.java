package com.thoughtworks.nho.nho29.web.controller;

import com.thoughtworks.nho.nho29.authentication.util.SecurityUtils;
import com.thoughtworks.nho.nho29.domain.TrainingClub;
import com.thoughtworks.nho.nho29.domain.TrainingClubUser;
import com.thoughtworks.nho.nho29.service.TrainingClubService;
import com.thoughtworks.nho.nho29.service.TrainingClubUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@AllArgsConstructor
@RequestMapping("/training-clubs")
public class TraniningClubController {

    private TrainingClubUserService trainingClubUserService;

    private TrainingClubService trainingClubService;

    @GetMapping
    public Collection<TrainingClub> findTraniningClubsByTraniningClubUserId() {
        TrainingClubUser user = TrainingClubUser.class.cast(SecurityUtils.getPrincipal());
        user = this.trainingClubUserService.findOne(user.getId());
        return user.getTrainingClubs();
    }

    @GetMapping("/{traniningClubId}")
    public TrainingClub findTraniningClubsById(@PathVariable("traniningClubId") Long traniningClubId) {
        return this.trainingClubService.findTrainingClubById(traniningClubId);
    }
}
