package com.cute.java.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.cute.java"})
public class CuteRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CuteRestApplication.class, args);
    }
}
