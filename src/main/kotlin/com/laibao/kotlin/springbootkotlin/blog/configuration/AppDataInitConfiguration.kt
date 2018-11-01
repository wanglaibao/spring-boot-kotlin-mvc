package com.laibao.kotlin.springbootkotlin.blog.configuration

import com.laibao.kotlin.springbootkotlin.blog.domain.Article
import com.laibao.kotlin.springbootkotlin.blog.domain.Customer
import com.laibao.kotlin.springbootkotlin.blog.domain.User
import com.laibao.kotlin.springbootkotlin.blog.repository.ArticleRepository
import com.laibao.kotlin.springbootkotlin.blog.repository.CustomerRepository
import com.laibao.kotlin.springbootkotlin.blog.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @author laibao wang
 */

@EnableConfigurationProperties(BlogProperties::class)
@Configuration
class AppDataInitConfiguration {
    private val logger = LoggerFactory.getLogger(AppDataInitConfiguration::class.java)

    @Bean
    fun init(repository: CustomerRepository) = CommandLineRunner {
        // save a couple of customers
        repository.save(Customer("Jack", "Bauer"))
        repository.save(Customer("Chloe", "O'Brian"))
        repository.save(Customer("Kim", "Bauer"))
        repository.save(Customer("David", "Palmer"))
        repository.save(Customer("Michelle", "Dessler"))

        // fetch all customers
        logger.info("Customers found with findAll():")
        logger.info("-------------------------------")
        repository.findAll().forEach { logger.info(it.toString()) }
        logger.info("")

        // fetch an individual customer by ID
        val customer = repository.findById(1L)
        customer.ifPresent {
            logger.info("Customer found with findById(1L):")
            logger.info("--------------------------------")
            logger.info(it.toString())
            logger.info("")
        }

        // fetch customers by last name
        logger.info("Customer found with findByLastName('Bauer'):")
        logger.info("--------------------------------------------")
        repository.findByLastName("Bauer").forEach { logger.info(it.toString()) }
        logger.info("")
    }

    @Bean
    fun databaseInitializer(userRepository: UserRepository,
                            articleRepository: ArticleRepository) = CommandLineRunner {
        val smaldini = User("smaldini", "Stéphane", "Maldini")
        userRepository.save(smaldini)

        articleRepository.save(Article(
                "Reactor Bismuth is out",
                "Lorem ipsum",
                "dolor **sit** amet https://projectreactor.io/",
                smaldini,
                1
        ))

        articleRepository.save(Article(
                "Reactor Aluminium has landed",
                "Lorem ipsum",
                "dolor **sit** amet https://projectreactor.io/",
                smaldini,
                2
        ))
    }

}