package com.laibao.kotlin.springbootkotlin.blog.repository

import com.laibao.kotlin.springbootkotlin.blog.domain.Article
import com.laibao.kotlin.springbootkotlin.blog.domain.User
import org.springframework.data.repository.CrudRepository

/**
 * @author laibao wang
 */
interface UserRepository : CrudRepository<User, String> {
    //fun findAllUsers(): Iterable<User>
}