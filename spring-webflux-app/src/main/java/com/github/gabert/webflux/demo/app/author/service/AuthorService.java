package com.github.gabert.webflux.demo.app.author.service;

import com.github.gabert.webflux.demo.app.author.dal.AuthorDocument;
import com.github.gabert.webflux.demo.app.author.dal.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public Mono<String> createAuthor(AuthorCreateRequest authorCreateRequest) {
        return authorRepository.findByName(authorCreateRequest.getName())
                .hasElements()
                .flatMap(alreadyExists -> alreadyExists
                        ? Mono.error(new IllegalArgumentException("Author: " +
                                                                  authorCreateRequest.getName() +
                                                                  " already exists."))
                        : insertAuthor(authorCreateRequest));
    }

    private Mono<String> insertAuthor(AuthorCreateRequest authorCreateRequest) {
        return Mono.just(authorCreateRequest)
                   .map(AuthorMapper::mapToDocument)
                   .flatMap(authorRepository::save)
                   .map(AuthorDocument::getId);
    }

    public Flux<AuthorDetailResponse> listAuthors() {
        return authorRepository.findAll()
                               .map(AuthorMapper::mapToResponse);
    }
}
