package com.example.kotlinspringchattesttask.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*
import java.time.OffsetDateTime
import java.util.*

@Entity
data class Chat(
    @Id
    val id: UUID,
    val name: String,
    val created_at: OffsetDateTime,

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "chat_id", nullable = false)
    @JsonIgnoreProperties(*arrayOf("hibernateLazyInitializer", "handler"))
    val users: MutableList<ChatMember> = ArrayList()
)