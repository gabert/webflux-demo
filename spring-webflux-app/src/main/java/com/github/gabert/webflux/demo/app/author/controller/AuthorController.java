package com.github.gabert.webflux.demo.app.author.controller;

import com.github.gabert.webflux.demo.app.author.service.AuthorCreateRequest;
import com.github.gabert.webflux.demo.app.author.service.AuthorDetailResponse;
import com.github.gabert.webflux.demo.app.author.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping("/api/authors")
    public Mono<ResponseEntity<String>> createAuthor(@RequestBody AuthorCreateRequest authorCreateRequest) {
        return authorService.createAuthor(authorCreateRequest)
                .map(id -> ResponseEntity.status(201)
                                         .body(id))
                .onErrorResume(error -> Mono.just(ResponseEntity.badRequest()
                                                                .body(error.getMessage())));
    }

    @GetMapping("/api/authors")
    public Flux<AuthorDetailResponse> getAllAuthors() {
        return authorService.listAuthors();
    }
}
