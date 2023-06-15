package com.example.kotlinspringchattesttask.service

import com.example.kotlinspringchattesttask.dto.AddChat
import com.example.kotlinspringchattesttask.dto.ChatsGet
import com.example.kotlinspringchattesttask.entity.Chat
import com.example.kotlinspringchattesttask.entity.ChatMember
import com.example.kotlinspringchattesttask.exception.BadRequestException
import com.example.kotlinspringchattesttask.repository.ChatRepository
import com.example.kotlinspringchattesttask.repository.UserRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.time.OffsetDateTime
import java.util.*


@Service
class ChatService(val userRepository: UserRepository, val chatRepository: ChatRepository) {
    @Transactional
    fun createChat(dto: AddChat): UUID {
        if (dto.name.isNullOrEmpty()) throw BadRequestException("empty name")
        if (dto.users.isNullOrEmpty()) throw BadRequestException("empty users")

        val users = userRepository.findByIdIn(dto.users)
        if (users.size != dto.users.size) throw BadRequestException("users not found")

        var chat = Chat(
            UUID.randomUUID(),
            dto.name,
            OffsetDateTime.now()
        )
        chat = chatRepository.save(chat)
        for (user in users) {
            val chatMember = ChatMember(
                UUID.randomUUID(),
                user
            )

            chat.users.add(chatMember)
        }
        return chat.id
    }

    fun getChats(dto: ChatsGet): List<Chat> {
        if(dto.user == null)
            throw BadRequestException("empty user")
        return chatRepository.findAllByUsersUserId(dto.user!!)
    }
}