package com.thoughtworks.nho.nho29.web.controller;

import com.thoughtworks.nho.nho29.domain.Doc;
import com.thoughtworks.nho.nho29.domain.TaskCard;
import com.thoughtworks.nho.nho29.service.DocService;
import com.thoughtworks.nho.nho29.service.TaskCardService;
import com.thoughtworks.nho.nho29.vo.TaskCardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TaskCardController {

    private final TaskCardService taskCardService;

    private final DocService docService;

    public TaskCardController(TaskCardService taskCardService, DocService docService) {
        this.taskCardService = taskCardService;
        this.docService = docService;
    }

    @GetMapping("training-clubs/{clubId}/task-cards/{cardId}")
    public TaskCardVO getTrainingCard(@PathVariable Long clubId, @PathVariable Long cardId) {
        TaskCard taskCard = taskCardService.getTaskCardById(cardId);
        List<Doc> docs = docService.getDocsByTaskCardId(cardId);
        return new TaskCardVO(taskCard, docs);
    }

    @GetMapping("training-clubs/{clubId}/task-cards")
    public List<TaskCard> getTrainingCardsByTrainingClubId(@PathVariable Long clubId){
        return taskCardService.getTaskCardListByTrainingClubId(clubId);
    }
}
