package com.librarian.elibrarian.service

import com.librarian.elibrarian.model.Book
import java.util.*

interface BookService {
    fun add(book: Book): Book
    fun getAll(): List<Book>
    fun getById(bookId: Int): Optional<Book>
    fun update(book: Book): Book
    fun remove(bookId: Int): Int
}