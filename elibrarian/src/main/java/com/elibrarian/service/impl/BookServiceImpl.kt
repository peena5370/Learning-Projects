package com.librarian.elibrarian.service.impl

import com.librarian.elibrarian.model.Book
import com.librarian.elibrarian.repos.BookRepository
import com.librarian.elibrarian.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class BookServiceImpl(@Autowired private val bookRepository: BookRepository): BookService {
    override fun add(book: Book): Book {
        return bookRepository.saveAndFlush(book)
    }

    override fun getAll(): List<Book> {
        return bookRepository.findAll()
    }

    override fun getById(bookId: Int): Optional<Book> {
        return bookRepository.findById(bookId)
    }

    override fun update(book: Book): Book {
        return bookRepository.saveAndFlush(book)
    }

    override fun remove(bookId: Int): Int {
        var row: Int = 0
        row = try {
            bookRepository.deleteById(bookId)
            1
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            0
        }
        return row
    }
}