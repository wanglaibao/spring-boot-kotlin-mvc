package com.laibao.kotlin.springbootkotlin.blog.repository

import com.laibao.kotlin.springbootkotlin.blog.domain.Customer
import org.springframework.data.repository.CrudRepository

/**
 * @author laibao wang
 */
interface CustomerRepository: CrudRepository<Customer, Long> {
    fun findByLastName(lastName: String): Iterable<Customer>
}