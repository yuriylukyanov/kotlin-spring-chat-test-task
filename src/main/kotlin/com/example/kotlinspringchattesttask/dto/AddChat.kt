package com.example.kotlinspringchattesttask.dto

import java.util.*

data class AddChat(
    val name: String? = null,
    val users: List<UUID>? = null
)


