package com.laibao.kotlin.springbootkotlin.blog.configuration

import com.laibao.kotlin.springbootkotlin.blog.domain.Article
import com.laibao.kotlin.springbootkotlin.blog.domain.User
import com.laibao.kotlin.springbootkotlin.blog.repository.ArticleRepository
import com.laibao.kotlin.springbootkotlin.blog.repository.UserRepository
import com.samskivert.mustache.Mustache
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @author laibao wang
 */
@Configuration
class ApplicationConfiguration {

    @Bean
    fun mustacheCompiler(loader: Mustache.TemplateLoader?) = Mustache.compiler().escapeHTML(false).withLoader(loader)

}