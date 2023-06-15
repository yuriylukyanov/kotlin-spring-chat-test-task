package com.example.kotlinspringchattesttask.service

import com.example.kotlinspringchattesttask.dto.AddMessage
import com.example.kotlinspringchattesttask.dto.MessagesEntryCount
import com.example.kotlinspringchattesttask.dto.MessagesGet
import com.example.kotlinspringchattesttask.entity.Message
import com.example.kotlinspringchattesttask.exception.BadRequestException
import com.example.kotlinspringchattesttask.repository.ChatMemberRepository
import com.example.kotlinspringchattesttask.repository.ChatRepository
import com.example.kotlinspringchattesttask.repository.MessageRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.time.OffsetDateTime
import java.util.*


@Service
class MessageService(
    val chatRepository: ChatRepository,
    val chatMemberRepository: ChatMemberRepository,
    val messageRepository: MessageRepository
) {
    @Transactional
    fun createMessage(dto: AddMessage): UUID {
        if (dto.author == null) throw BadRequestException("empty author")
        if (dto.chat == null) throw BadRequestException("empty chat")
        if (dto.text.isNullOrEmpty()) throw BadRequestException("empty text")
        val chat = chatRepository.findAllById(java.util.List.of(dto.chat))
        if (chat.isEmpty()) throw BadRequestException("chat not found")
        val member = chatRepository.findUsersByIdAndUsersUserId(dto.chat, dto.author)
        if (member.isEmpty()) throw BadRequestException("author not found")
        val message = Message(
            UUID.randomUUID(),
            dto.text,
            OffsetDateTime.now(),
            member.get(0),
            chat.get(0))
        messageRepository.save<Message>(message)
        return message.id
    }

    fun getMessages(dto: MessagesGet): List<Message> {
        if (dto.chat == null) throw BadRequestException("empty chat")
        return messageRepository.findAllByChatId(dto.chat)
    }

    fun getEntryCount(dto: MessagesEntryCount): Int {
        if (dto.chat == null) throw BadRequestException("empty chat")

        val text = if (dto.text.isNullOrEmpty()) "" else dto.text;
        return messageRepository.countByChatIdAndTextLike(dto.chat, "%$text%")
    }
}