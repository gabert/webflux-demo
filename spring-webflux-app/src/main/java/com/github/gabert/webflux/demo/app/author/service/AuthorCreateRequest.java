package com.github.gabert.webflux.demo.app.author.service;

import lombok.Data;

import java.util.List;

@Data
public class AuthorCreateRequest {
    private String name;

    private List<BookDetail> books;
}
