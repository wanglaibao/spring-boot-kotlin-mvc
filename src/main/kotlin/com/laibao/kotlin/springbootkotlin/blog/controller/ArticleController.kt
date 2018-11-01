package com.laibao.kotlin.springbootkotlin.blog.controller

import com.laibao.kotlin.springbootkotlin.blog.converter.MarkdownConverter
import com.laibao.kotlin.springbootkotlin.blog.repository.ArticleRepository
import org.springframework.web.bind.annotation.*

/**
 * @author laibao wang
 */
@RestController
@RequestMapping("/api/article")
class ArticleController (private val articleRepository: ArticleRepository,
                         private val markdownConverter: MarkdownConverter){

    @GetMapping("/")
    fun findAll() = articleRepository.findAllByOrderByAddedAtDesc()

    @GetMapping("/{id}")
    fun findOne(@PathVariable id: Long, @RequestParam converter: String?)
            = when (converter) {
                                    "markdown" -> articleRepository.findById(id).map { it.copy(
                                            headline = markdownConverter.invoke(it.headline),
                                            content = markdownConverter.invoke(it.content)) }
                                    null -> articleRepository.findById(id)
                                    else -> throw IllegalArgumentException("Only markdown converter is supported")
    }
}