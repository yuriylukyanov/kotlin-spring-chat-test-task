package com.example.kotlinspringchattesttask.repository

import com.example.kotlinspringchattesttask.entity.Message
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
public interface MessageRepository: JpaRepository<Message, UUID> {
    fun findAllByChatId(chatId: UUID): List<Message>
    fun countByChatIdAndTextLike(chatId: UUID, text: String): Int
}