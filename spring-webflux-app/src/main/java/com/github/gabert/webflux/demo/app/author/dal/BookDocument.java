package com.github.gabert.webflux.demo.app.author.dal;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BookDocument {
    private String title;
    private String isbn;
}
