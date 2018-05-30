package com.thoughtworks.nho.nho29.vo;

import com.thoughtworks.nho.nho29.domain.Doc;
import com.thoughtworks.nho.nho29.domain.TaskCard;

import java.util.List;

public class TaskCardVO {
    private Long id;

    private String name;

    private String imgUrl;

    private String description;

    private List<DocVO> docs;

    private Long clubId;

    public TaskCardVO(TaskCard taskCard, List<Doc> docs) {

    }
}
