package com.thoughtworks.nho.nho29.service;

import com.thoughtworks.nho.nho29.domain.Doc;

import java.util.List;

public interface DocService {
    List<Doc> getDocsByTaskCardId(Long taskCardId);
}
