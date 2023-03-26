package com.github.gabert.async.demo.logic;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

import static com.github.gabert.async.demo.logic.ThreadUtil.sleep;

@RestController
public class AsyncController {
    @GetMapping("/async_result")
    @Async
    public CompletableFuture getResultAsyc(HttpServletRequest request) {
        sleep(200);

        return CompletableFuture.completedFuture("Result is ready!");
    }
}