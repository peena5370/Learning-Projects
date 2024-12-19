package com.librarian.elibrarian.service

import com.librarian.elibrarian.model.Librarian
import java.util.*

interface LibrarianService {
    fun add(librarian: Librarian): Librarian
    fun getAll(): List<Librarian>
    fun getById(libId: Int): Optional<Librarian>
    fun update(librarian: Librarian): Librarian
    fun remove(libId: Int): Int
}