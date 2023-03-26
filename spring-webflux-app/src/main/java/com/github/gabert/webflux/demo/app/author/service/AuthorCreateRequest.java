package com.github.gabert.webflux.demo.app.author.service;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class AuthorCreateRequest {
    private String name;

    private List<BookDetail> books;
}
