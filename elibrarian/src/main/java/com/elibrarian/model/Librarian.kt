package com.librarian.elibrarian.model

import jakarta.persistence.*

@Entity
@Table(name="e_librarian")
data class Librarian(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="lib_id")
        var libId: Int,
        @Column(name="lib_name", nullable = false)
        var libName: String,
        @Column(name="lib_phone")
        var libPhone: String,
        @Column(name="lib_email")
        var libEmail: String,
        @OneToOne
        @JoinColumn(name="u_id")
        var users: Users
)
