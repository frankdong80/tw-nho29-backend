package com.thoughtworks.nho.nho29.web.controller;

import com.thoughtworks.nho.nho29.authentication.util.SecurityUtils;
import com.thoughtworks.nho.nho29.domain.TrainingClubUser;
import com.thoughtworks.nho.nho29.service.TrainingClubService;
import com.thoughtworks.nho.nho29.service.TrainingClubUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/training-clubs")
public class TraniningClubController {

    private TrainingClubUserService trainingClubUserService;

    private TrainingClubService trainingClubService;

    @GetMapping
    public Map<String, Object> findTraniningClubsByTraniningClubUserId() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", 200);
        response.put("message", "load data success");

        TrainingClubUser user = TrainingClubUser.class.cast(SecurityUtils.getPrincipal());
        user = this.trainingClubUserService.findOne(user.getId());
        response.put("data",user.getTrainingClubs());

        return response;
    }

    @GetMapping("/{traniningClubId}")
    public Map<String, Object> findTraniningClubsById(@PathVariable("traniningClubId") Long traniningClubId) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", 200);
        response.put("message", "load data success");
        response.put("data",this.trainingClubService.findTrainingClubById(traniningClubId));
        return response;
    }
}
