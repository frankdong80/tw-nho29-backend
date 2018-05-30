package com.thoughtworks.nho.nho29.service;

import com.thoughtworks.nho.nho29.domain.TaskCard;

import java.util.List;

public interface TaskCardService {

    TaskCard getTaskCardById(Long id);

    List<TaskCard> getTaskCardListByTrainingClubId (Long id);
}
