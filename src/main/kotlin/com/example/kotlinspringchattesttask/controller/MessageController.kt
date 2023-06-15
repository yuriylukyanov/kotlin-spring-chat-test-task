package com.example.kotlinspringchattesttask.controller

import com.example.kotlinspringchattesttask.dto.*
import com.example.kotlinspringchattesttask.service.MessageService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("messages")
class MessageController(val service: MessageService) {
    @PostMapping("add")
    fun createMessage(@RequestBody dto: AddMessage) = ResponseEntity.ok(service.createMessage(dto))

    @PostMapping("get")
    fun getMessages(@RequestBody dto: MessagesGet) = ResponseEntity.ok(service.getMessages(dto))

    @PostMapping("entry/count")
    fun entryCount(@RequestBody dto: MessagesEntryCount) = ResponseEntity.ok(service.getEntryCount(dto))
}