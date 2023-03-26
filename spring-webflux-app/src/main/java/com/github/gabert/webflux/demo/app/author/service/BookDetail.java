package com.github.gabert.webflux.demo.app.author.service;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BookDetail {
    private String title;
    private String isbn;
}
