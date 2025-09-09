package com.elibrarian.demo.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.elibrarian.demo.model.BooksEntity;
import com.elibrarian.demo.repos.BooksRepository;
import com.elibrarian.demo.services.BooksService;

@Slf4j
@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    private BooksRepository booksRepository;

    @Override
    public BooksEntity addBook(BooksEntity book) {
        return booksRepository.saveAndFlush(book);
    }

    @Async
    @Override
    public CompletableFuture<List<BooksEntity>> viewBooks() {
        log.info("current thread run for viewBook: [{}]", Thread.currentThread().getName());

        List<BooksEntity> books = booksRepository.findAll();

        return CompletableFuture.completedFuture(books);
    }

    @Override
    public Optional<BooksEntity> viewBookById(Integer book_id) {
        return booksRepository.findById(book_id);
    }

    @Override
    public BooksEntity updateBook(BooksEntity book) {
        return booksRepository.saveAndFlush(book);
    }

    @Override
    public Integer removeBook(Integer book_id) {
        Integer row = 0;
        try {
            booksRepository.deleteById(book_id);
            row = 1;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            row = 0;
        }

        return row;
    }

}
