package com.laibao.kotlin.springbootkotlin.blog.domain

import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*

/**
 * @author laibao wang
 */
@Entity
data class Article (
        val title: String,
        val headline: String,
        val content: String,
        @ManyToOne @JoinColumn val author: User,
        @Id @GeneratedValue val id: Long? = null, // At the end to make it optional
        val addedAt: LocalDateTime = LocalDateTime.now()): Serializable