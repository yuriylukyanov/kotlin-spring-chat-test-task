package com.example.kotlinspringchattesttask.controller

import com.example.kotlinspringchattesttask.dto.AddChat
import com.example.kotlinspringchattesttask.dto.ChatsGet
import com.example.kotlinspringchattesttask.exception.BadRequestException
import com.example.kotlinspringchattesttask.service.ChatService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("chats")
class ChatController(val service: ChatService) {
    @PostMapping("add")
    fun createChat(@RequestBody dto: AddChat) = ResponseEntity.ok(service.createChat(dto))

    @PostMapping("get")
    fun getChats(@RequestBody dto: ChatsGet) = ResponseEntity.ok<Any>(service.getChats(dto))
}