package com.github.gabert.async.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AsyncPerfDemoApp {
    public static void main(String[] args) {
        SpringApplication.run(AsyncPerfDemoApp.class, args);
    }
}
