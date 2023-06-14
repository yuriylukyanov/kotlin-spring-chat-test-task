package com.example.kotlinspringchattesttask.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.util.*

@Entity
data class ChatMember(
    @Id
    val id: UUID,

    @JsonIgnoreProperties(*arrayOf("hibernateLazyInitializer", "handler"))
    @ManyToOne(fetch = FetchType.EAGER)
    val user: User
)

