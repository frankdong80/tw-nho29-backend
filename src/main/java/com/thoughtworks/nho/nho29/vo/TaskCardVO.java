package com.thoughtworks.nho.nho29.vo;

import com.thoughtworks.nho.nho29.domain.Doc;
import com.thoughtworks.nho.nho29.domain.TaskCard;
import lombok.Data;

import java.util.List;

@Data
public class TaskCardVO {
    private Long id;

    private String name;

    private String icon;

    private String description;

    private List<DocVO> docs;

    private Long trainingClubId;

    public TaskCardVO(TaskCard taskCard, List<Doc> docs) {

    }
}
