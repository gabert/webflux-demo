package com.github.gabert.webflux.demo.app.author.service;

import com.github.gabert.webflux.demo.app.author.dal.AuthorDocument;
import com.github.gabert.webflux.demo.app.author.dal.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {
    private static String NOT_IMPORTANT = "";

    @InjectMocks
    private AuthorService authorService;

    @Mock
    private AuthorRepository authorRepository;

    @Test
    void createAuthorValid() {
        final String TEST_ID = "AAA-111";

        when(authorRepository.findByName(any()))
                .thenReturn(Flux.empty());

        when(authorRepository.save(any()))
                .thenReturn(Mono.just(new AuthorDocument().setName(NOT_IMPORTANT)
                                                          .setId(TEST_ID)
                                                          .setBooks(new ArrayList<>())));

        Mono<String> id = authorService.createAuthor(new AuthorCreateRequest().setName(NOT_IMPORTANT)
                                                                              .setBooks(new ArrayList<>()));

        StepVerifier.create(id)
                .assertNext(result -> assertEquals(result, TEST_ID))
                .verifyComplete();
    }
    @Test
    void createAuthorAlreadyExists() {
        when(authorRepository.findByName(any()))
                .thenReturn(Flux.just(new AuthorDocument().setId(NOT_IMPORTANT)
                                                          .setName(NOT_IMPORTANT)));

        Mono<String> id = authorService.createAuthor(new AuthorCreateRequest().setName(NOT_IMPORTANT)
                                                                              .setBooks(new ArrayList<>()));

        StepVerifier.create(id)
                .expectError()
                .verify();
    }
}