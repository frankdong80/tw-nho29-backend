package com.thoughtworks.nho.nho29.service.impl;

import com.thoughtworks.nho.nho29.domain.Doc;
import com.thoughtworks.nho.nho29.service.DocService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocServiceImpl implements DocService {
    @Override
    public List<Doc> getDocsByTaskCardId(Long taskCardId) {
        return null;
    }
}
