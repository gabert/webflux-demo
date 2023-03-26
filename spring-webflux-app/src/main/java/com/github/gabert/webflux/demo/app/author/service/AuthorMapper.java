package com.github.gabert.webflux.demo.app.author.service;

import com.github.gabert.webflux.demo.app.author.dal.AuthorDocument;
import com.github.gabert.webflux.demo.app.author.dal.BookDocument;

import java.util.List;

public final class AuthorMapper {
    public static AuthorDocument mapToDocument(AuthorCreateRequest authorCreateRequest) {
        return new AuthorDocument().setName(authorCreateRequest.getName())
                .setBooks(mapToDocument(authorCreateRequest.getBooks()));
    }

    private static List<BookDocument> mapToDocument(List<BookDetail> bookDetails) {
        return bookDetails.stream()
                .map(bookDetail -> new BookDocument().setTitle(bookDetail.getTitle())
                                                     .setIsbn(bookDetail.getIsbn()))
                .toList();
    }

    public static AuthorDetailResponse mapToResponse(AuthorDocument authorDocument) {
        return new AuthorDetailResponse().setId(authorDocument.getId())
                .setName(authorDocument.getName())
                .setBooks(mapToResponse(authorDocument.getBooks()));
    }

    private static List<BookDetail> mapToResponse(List<BookDocument> bookDocuments) {
        return bookDocuments.stream()
                .map(bookDocument -> new BookDetail().setTitle(bookDocument.getTitle())
                        .setIsbn(bookDocument.getIsbn()))
                .toList();
    }
}
