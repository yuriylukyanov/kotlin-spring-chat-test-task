package com.example.kotlinspringchattesttask.dto

import java.util.*

data class AddMessage(
    val chat: UUID?,
    val author: UUID?,
    val text: String?
)


