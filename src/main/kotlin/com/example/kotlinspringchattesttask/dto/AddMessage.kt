package com.example.kotlinspringchattesttask.dto

import java.util.*

data class AddMessage(
    val chat: UUID? = null,
    val author: UUID? = null,
    val text: String? = null
)


