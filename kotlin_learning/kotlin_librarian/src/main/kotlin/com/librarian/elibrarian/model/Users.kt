package com.librarian.elibrarian.model

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity
@Table(name="e_users")
@EntityListeners(AuditingEntityListener::class)
data class Users(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="u_id")
        var uId: Int?,
        @Column(name="username", unique = true, nullable = false)
        var username: String,
        @Column(name="password")
        var password: String,
        @Column(name="secretkey")
        var secretKey: String?,
        @CreatedDate
        @Column(name="createtime", updatable = false)
        var createTime: LocalDateTime?,
        @LastModifiedDate
        @Column(name="updatetime")
        var updateTime: LocalDateTime?
)
