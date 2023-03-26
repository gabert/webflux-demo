package com.github.gabert.webflux.demo.app.author.dal;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface AuthorRepository extends ReactiveCrudRepository<AuthorDocument, String> {
    public Flux<AuthorDocument> findByName(String name);
}
