package com.thoughtworks.nho.nho29;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Nho29Application {

    public static void main(String[] args) {
        SpringApplication.run(Nho29Application.class, args);
    }
}
