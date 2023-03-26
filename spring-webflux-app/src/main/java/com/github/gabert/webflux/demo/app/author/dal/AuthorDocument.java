package com.github.gabert.webflux.demo.app.author.dal;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Accessors(chain = true)
@Document("author")
public class AuthorDocument {
    @Id
    private String id;

    @Indexed
    private String name;

    private List<BookDocument> books;
}
