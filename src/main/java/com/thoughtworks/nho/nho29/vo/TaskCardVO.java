package com.thoughtworks.nho.nho29.vo;

import com.thoughtworks.nho.nho29.domain.Doc;
import com.thoughtworks.nho.nho29.domain.TaskCard;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class TaskCardVO {
    private Long id;

    private String name;

    private String icon;

    private String description;

    private Long trainingClubId;

    private List<DocVO> docs;

    public TaskCardVO(TaskCard taskCard, List<Doc> docs) {
        this.id = taskCard.getId();
        this.name = taskCard.getName();
        this.icon = taskCard.getIcon();
        this.description = taskCard.getDescription();
        this.trainingClubId = taskCard.getTrainingClubId();
        this.docs = docs.stream().map(DocVO::new).collect(Collectors.toList());
    }
}
