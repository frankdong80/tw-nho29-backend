package com.thoughtworks.nho.nho29.web.controller;

import com.thoughtworks.nho.nho29.domain.User;
import com.thoughtworks.nho.nho29.domain.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionTimedOutException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(value = "/auth", produces = APPLICATION_JSON_UTF8_VALUE)
@Slf4j
public class LoginController {
    @Autowired
    UserRepository repo;

    @GetMapping
    public User getUser() {
        if(true) throw new RuntimeException("some");
        return repo.getOne(0l);
    }
}
