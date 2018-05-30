package com.thoughtworks.nho.nho29.web.controller;

import com.thoughtworks.nho.nho29.domain.TaskCard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TaskCardController {

    @GetMapping("training-clubs/{clubId}/training-cards/{cardId}")
    public TaskCard getTrainingCard(@PathVariable Long clubId, @PathVariable Long cardId){
        return  null;
    }
}
