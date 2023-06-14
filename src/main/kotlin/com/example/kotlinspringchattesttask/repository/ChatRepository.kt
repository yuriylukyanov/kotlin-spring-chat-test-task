package com.example.kotlinspringchattesttask.repository

import com.example.kotlinspringchattesttask.entity.Chat
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ChatRepository : JpaRepository<Chat, UUID> {
    fun findAllByUsersUserId(userId: UUID): List<Chat>
}