package com.librarian.elibrarian.controller

import com.librarian.elibrarian.model.Book
import com.librarian.elibrarian.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/books")
class BookController(@Autowired private val bookService: BookService) {

    @PostMapping
    fun add(@RequestBody book: Book): ResponseEntity<Book> {
        return ResponseEntity.ok(bookService.add(book))
    }

    @GetMapping
    fun list(): ResponseEntity<List<Book>> {
        return ResponseEntity.ok(bookService.getAll())
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): ResponseEntity<Optional<Book>> {
        return ResponseEntity.ok(bookService.getById(id))
    }

    @PutMapping("{id}")
    fun update(@RequestBody book: Book): ResponseEntity<Book> {
        return ResponseEntity.ok(bookService.update(book))
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Int): ResponseEntity<Int> {
        return ResponseEntity.ok(bookService.remove(id))
    }
}