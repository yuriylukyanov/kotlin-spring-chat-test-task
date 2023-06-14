package com.example.kotlinspringchattesttask.repository

import com.example.kotlinspringchattesttask.entity.ChatMember
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface ChatMemberRepository : JpaRepository<ChatMember, UUID> {
}


