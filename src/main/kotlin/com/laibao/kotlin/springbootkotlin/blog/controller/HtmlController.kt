package com.laibao.kotlin.springbootkotlin.blog.controller

import com.laibao.kotlin.springbootkotlin.blog.configuration.BlogProperties
import com.laibao.kotlin.springbootkotlin.blog.converter.MarkdownConverter
import com.laibao.kotlin.springbootkotlin.blog.domain.Article
import com.laibao.kotlin.springbootkotlin.blog.domain.RenderedArticle
import com.laibao.kotlin.springbootkotlin.blog.extensions.format
import com.laibao.kotlin.springbootkotlin.blog.repository.ArticleRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

/**
 * @author laibao wang
 */
@Controller
class HtmlController (private val articleRepository: ArticleRepository,
                      private val markdownConverter: MarkdownConverter,
                      private val properties: BlogProperties){

    @GetMapping("/")
    fun blog(model: Model): String {
        model["title"] = properties.title
        model["banner"] = properties.banner
        model["articles"] = articleRepository.findAllByOrderByAddedAtDesc().map { it.render() }
        return "blog"
    }

    @GetMapping("/article/{id}")
    fun article(@PathVariable id: Long, model: Model): String {
        val article = articleRepository
                .findById(id)
                .orElseThrow { IllegalArgumentException("Wrong article id provided") }
                .render()
        model["title"] = article.title
        model["article"] = article
        return "article"
    }

    fun Article.render() = RenderedArticle(
            title,
            markdownConverter.invoke(headline),
            markdownConverter.invoke(content),
            author,
            id,
            addedAt.format()
    )
}