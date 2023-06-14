package com.example.kotlinspringchattesttask.dto

import java.util.*

data class AddChat(
    val name: String,
    val users: List<UUID>
)


