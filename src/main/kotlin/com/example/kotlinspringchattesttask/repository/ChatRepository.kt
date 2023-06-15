package com.example.kotlinspringchattesttask.repository

import com.example.kotlinspringchattesttask.entity.Chat
import com.example.kotlinspringchattesttask.entity.ChatMember
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ChatRepository : JpaRepository<Chat, UUID> {
    fun findAllByUsersUserId(userId: UUID): List<Chat>

    @Query("select m from Chat c join fetch ChatMember m where c.id = :id and m.user.id = :userId")
    fun findUsersByIdAndUsersUserId(
        @Param("id") id: UUID,
        @Param("userId") userId: UUID): List<ChatMember>
}