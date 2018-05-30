package com.thoughtworks.nho.nho29.vo;

import com.thoughtworks.nho.nho29.domain.Doc;
import lombok.Data;

@Data
public class DocVO {

    private Long id;
    private String name;
    private String url;


    public DocVO(Doc doc) {
        this.id = doc.getId();
        this.name = doc.getName();
        this.url = doc.getUrl();
    }
}
