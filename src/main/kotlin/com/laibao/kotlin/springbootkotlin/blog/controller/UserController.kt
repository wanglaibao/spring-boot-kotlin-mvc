package com.laibao.kotlin.springbootkotlin.blog.controller

import com.laibao.kotlin.springbootkotlin.blog.repository.UserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author laibao wang
 */
@RestController
@RequestMapping("/api/user")
class UserController (private val userRepository: UserRepository){

    @GetMapping("/")
    fun findAll() = userRepository.findAll()

    @GetMapping("/{login}")
    fun findOne(@PathVariable login: String) = userRepository.findById(login)
}