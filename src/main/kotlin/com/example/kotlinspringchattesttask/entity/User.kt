package com.example.kotlinspringchattesttask.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.OffsetDateTime
import java.util.*

@Entity
@Table(name = "\"user\"")
data class User(

    @Id
    val id: UUID,

    val username: String,

    val created_at: OffsetDateTime
)

