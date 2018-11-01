package com.laibao.kotlin.springbootkotlin.blog.domain

import java.io.Serializable

/**
 * @author laibao wang
 */
data class RenderedArticle (val title: String,
                             val headline: String,
                             val content: String,
                             val author: User,
                             val id: Long?,
                             val addedAt: String) : Serializable