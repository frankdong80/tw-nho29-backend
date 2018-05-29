package com.thoughtworks.nho.nho29.web.controller;

import com.thoughtworks.nho.nho29.domain.User;
import com.thoughtworks.nho.nho29.domain.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@Api(tags = "Login Service")
@SwaggerDefinition(tags = @Tag(
        name = "Login",
        description = "Login service"))
@RestController
@RequestMapping(value =  "/auth", produces = APPLICATION_JSON_UTF8_VALUE)
@Slf4j
public class LoginController {
    @Autowired
    UserRepository repo;

    @GetMapping
    public User getUser() {
        return repo.getOne(0l);
    }
}
