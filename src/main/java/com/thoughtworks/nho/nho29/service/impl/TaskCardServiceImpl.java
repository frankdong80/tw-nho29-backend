package com.thoughtworks.nho.nho29.service.impl;

import com.thoughtworks.nho.nho29.domain.TaskCard;
import com.thoughtworks.nho.nho29.domain.TaskCardRepository;
import com.thoughtworks.nho.nho29.service.TaskCardService;
import jdk.nashorn.internal.objects.annotations.Constructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskCardServiceImpl implements TaskCardService {

    private TaskCardRepository repo;

    public TaskCardServiceImpl(@Autowired TaskCardRepository repo) {
        this.repo = repo;
    }

    @Override
    public TaskCard getTaskCardById(Long id) {

        return null;
    }

    public List<TaskCard> getTaskCardListByTrainingClubId (Long id) {
        return repo.findAllByTrainingClubId(id);
    }
}
