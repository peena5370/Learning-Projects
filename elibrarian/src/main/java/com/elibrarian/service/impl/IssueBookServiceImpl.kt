package com.librarian.elibrarian.service.impl

import com.librarian.elibrarian.model.Book
import com.librarian.elibrarian.model.IssueBook
import com.librarian.elibrarian.repos.BookRepository
import com.librarian.elibrarian.repos.IssueBookRepository
import com.librarian.elibrarian.service.IssueBookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class IssueBookServiceImpl(@Autowired private val bookRepository: BookRepository,
                           @Autowired private val issueBookRepository: IssueBookRepository): IssueBookService {
    override fun issueBook(issueBook: IssueBook): IssueBook? {
        val book: Optional<Book> = bookRepository.findById(issueBook.book.bookId)
        var savedEntity: IssueBook? = null
        if(book.isPresent) {
            val bookEntity: Book = book.get()
            if(bookEntity.bookIssued!! >= bookEntity.bookQuantity!!) {
                throw RuntimeException("no more books can be issued")
            } else {
                bookEntity.bookIssued = bookEntity.bookIssued!! + 1
                bookRepository.save(bookEntity)

                savedEntity = issueBookRepository.save(issueBook)
            }
        }
        return savedEntity
    }

    override fun getAll(): List<IssueBook> {
        return issueBookRepository.findAll()
    }

    override fun getById(issueId: Int): Optional<IssueBook> {
        return issueBookRepository.findById(issueId)
    }

    override fun returnBook(issueBook: IssueBook): IssueBook? {
        val book: Optional<Book> = bookRepository.findById(issueBook.book.bookId)
        var updateEntity: IssueBook? = null
        if(book.isPresent) {
            val bookEntity: Book = book.get()
            if(bookEntity.bookIssued==0) {
                throw RuntimeException("book issued is zero")
            } else {
                bookEntity.bookIssued = bookEntity.bookIssued?.minus(1)
                bookRepository.save(bookEntity)

                updateEntity = issueBookRepository.save(issueBook)
            }
        }
        return updateEntity
    }
}