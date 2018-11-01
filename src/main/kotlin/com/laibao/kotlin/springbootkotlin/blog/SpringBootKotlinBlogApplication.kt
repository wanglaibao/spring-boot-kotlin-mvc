package com.laibao.kotlin.springbootkotlin.blog

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootKotlinBlogApplication {

    private val logger: Logger = LoggerFactory.getLogger(SpringBootKotlinBlogApplication::class.java)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<SpringBootKotlinBlogApplication>(*args){
                setBannerMode(Banner.Mode.OFF)
            }
        }
    }
}


