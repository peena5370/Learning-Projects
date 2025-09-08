package com.elibrarian.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import com.elibrarian.demo.model.BooksEntity;

public interface BooksService {
    BooksEntity addBook(BooksEntity book);

    CompletableFuture<List<BooksEntity>> viewBooks();

    Optional<BooksEntity> viewBookById(Integer book_id);

    BooksEntity updateBook(BooksEntity book);

    Integer removeBook(Integer book_id);
}
