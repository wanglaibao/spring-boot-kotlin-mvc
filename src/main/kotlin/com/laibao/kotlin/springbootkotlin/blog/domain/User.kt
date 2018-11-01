package com.laibao.kotlin.springbootkotlin.blog.domain

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.Id

/**
 * @author laibao wang
 */
@Entity
data class User (
        @Id val login: String,
        val firstName: String,
        val lastName: String,
        val description: String? = null) : Serializable