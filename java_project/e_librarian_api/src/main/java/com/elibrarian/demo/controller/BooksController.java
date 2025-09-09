package com.elibrarian.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elibrarian.demo.model.BooksEntity;
import com.elibrarian.demo.services.BooksService;

@Slf4j
@RestController
@RequestMapping("/api/books")
public class BooksController {

    private BooksService booksService;
    private final TransactionTemplate transactionTemplate;

    public BooksController(BooksService booksService, PlatformTransactionManager platformTransactionManager) {
        this.booksService = booksService;
        this.transactionTemplate = new TransactionTemplate(platformTransactionManager);
    }

    @PostMapping
    public ResponseEntity<BooksEntity> addBook(@RequestBody BooksEntity book) {
        return ResponseEntity.ok(booksService.addBook(book));
    }

    /**
     * For functional programming, transaction only will rollback if exception being thrown out of the try catch block<br/>
     * or you can implement setRollbackOnly() to manually rollback the transaction
     * @param book bookentity
     * @return
     */
    @PostMapping("test-func-transaction")
    public ResponseEntity<Integer> testFuncionalTransaction(@RequestBody BooksEntity book) {
        int result = 0;

        transactionTemplate.execute(status -> {
            try {
                // execute query
                BooksEntity obj = booksService.addBook(book);

                // you can either manually set rollback inside the code block if no exception will be expected to be thrown
                status.setRollbackOnly();
//                int num = 10 / 0;

                return null;
            } catch (Exception e) {
                log.info("functional transaction encountered exception: {}", e.getMessage());
                throw e;
            }
        });

        return ResponseEntity.ok(result);
    }

    /**
     *
     * For declarative programming, transaction only rollback commit when unchecked exception being thrown in the annotated method <br/>
     * if want to rollback on checked exception, need to add in @Transactional(rollbackFor = IOException.class) in order to
     * rollback the commit
     * @param book bookentity
     * @return
     */
    @Transactional
    @PostMapping("/test-transaction")
    public ResponseEntity<Integer> testTransaction(@RequestBody BooksEntity book) {
        int result = 0;

        // execute query
        BooksEntity obj = booksService.addBook(book);

        log.info("book name: {}", obj.getBookname());

        // force some exception being throw out inside the transaction method to rollback the query
        try {
            int num = 10 / 0;
        } catch (Exception e) {
            log.info("exception thrown: {}", e.getMessage());
            throw e;
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<List<BooksEntity>> viewBooks() throws ExecutionException, InterruptedException {
        log.info("viewBooks controller started.");
        CompletableFuture<List<BooksEntity>> future = booksService.viewBooks();

        CompletableFuture.allOf(future);

        List<BooksEntity> result = future.join();
        log.info("viewBooks controller, future response: {}", future.isDone());

        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<BooksEntity>> viewBookById(@PathVariable Integer id) {
        return ResponseEntity.ok(booksService.viewBookById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BooksEntity> updateBook(@RequestBody BooksEntity book) {
        return ResponseEntity.ok(booksService.updateBook(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> removeBook(@PathVariable Integer id) {
        return ResponseEntity.ok(booksService.removeBook(id));
    }
}
