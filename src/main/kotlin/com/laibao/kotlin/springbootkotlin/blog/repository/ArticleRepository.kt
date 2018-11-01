package com.laibao.kotlin.springbootkotlin.blog.repository

import com.laibao.kotlin.springbootkotlin.blog.domain.Article
import org.springframework.data.repository.CrudRepository

/**
 * @author laibao wang.
 */
interface ArticleRepository : CrudRepository<Article,Long> {

    fun findAllByOrderByAddedAtDesc(): List<Article>
}