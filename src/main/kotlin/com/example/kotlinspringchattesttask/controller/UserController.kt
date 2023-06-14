package com.example.kotlinspringchattesttask.controller

import com.example.kotlinspringchattesttask.dto.AddUser
import com.example.kotlinspringchattesttask.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("users")
class UserController(val service: UserService) {

    @PostMapping("add")
    fun createUser(@RequestBody dto: AddUser) = ResponseEntity.ok(service.createUser(dto))
}