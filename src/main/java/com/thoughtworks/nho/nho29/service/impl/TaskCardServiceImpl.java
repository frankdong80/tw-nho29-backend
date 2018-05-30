package com.thoughtworks.nho.nho29.service.impl;

import com.thoughtworks.nho.nho29.domain.TaskCard;
import com.thoughtworks.nho.nho29.domain.TaskCardRepository;
import com.thoughtworks.nho.nho29.service.TaskCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskCardServiceImpl implements TaskCardService {
    @Autowired
    private TaskCardRepository taskCardRepository;

    @Override
    public TaskCard getTaskCardById(Long id) {

        return this.taskCardRepository.getOne(id);
    }

    public List<TaskCard> getTaskCardListByTrainingClubId (Long id) {
        return taskCardRepository.findAllByTrainingClubId(id);
    }
}
