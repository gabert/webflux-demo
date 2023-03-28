package com.github.gabert.webflux.demo.logic;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class WebFluxController {

    @GetMapping("/flux_result")
    public Mono getResult(ServerHttpRequest request) {
        return Mono.defer(() -> Mono.just("Result is ready!"))
                   .delaySubscription(Duration.ofMillis(200));
    }
}