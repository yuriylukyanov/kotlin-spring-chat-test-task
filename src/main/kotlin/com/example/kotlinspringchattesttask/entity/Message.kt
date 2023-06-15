package com.example.kotlinspringchattesttask.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.OffsetDateTime
import java.util.*

@Entity
data class Message(
    @Id
    val id: UUID,
    val text: String,
    val created_at: OffsetDateTime,

    @JsonIgnoreProperties(*arrayOf("hibernateLazyInitializer", "handler"))
    @ManyToOne(fetch = FetchType.EAGER)
    val author: ChatMember,

    @JsonIgnoreProperties(*arrayOf("hibernateLazyInitializer", "handler"))
    @ManyToOne(fetch = FetchType.EAGER)
    val chat: Chat
)
