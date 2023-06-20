package com.librarian.elibrarian.service.impl

import com.librarian.elibrarian.model.Librarian
import com.librarian.elibrarian.repos.LibrarianRepository
import com.librarian.elibrarian.service.LibrarianService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class LibrarianServiceImpl(@Autowired private val librarianRepository: LibrarianRepository): LibrarianService {
    override fun add(librarian: Librarian): Librarian {
        return librarianRepository.saveAndFlush(librarian)
    }

    override fun getAll(): List<Librarian> {
        return librarianRepository.findAll()
    }

    override fun getById(libId: Int): Optional<Librarian> {
        return librarianRepository.findById(libId)
    }

    override fun update(librarian: Librarian): Librarian {
        return librarianRepository.saveAndFlush(librarian)
    }

    override fun remove(libId: Int): Int {
        val row: Int = try {
            librarianRepository.deleteById(libId)
            1
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            0
        }

        return row
    }
}