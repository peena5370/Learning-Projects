package com.librarian.elibrarian.model

import jakarta.persistence.*
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@Entity
@Table(name="e_books")
@EntityListeners(AuditingEntityListener::class)
data class Book(
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(name="book_id")
        var bookId: Int,
        @Column(name="callno", unique = true, nullable = false)
        var callNo: String?,
        @Column(name="book_name", nullable = false)
        var bookName: String?,
        @Column(name="author")
        var author: String?,
        @Column(name="publisher")
        var publisher: String?,
        @Column(name="book_quantity")
        var bookQuantity: Int?,
        @Column(name="book_issued")
        var bookIssued: Int?
)
