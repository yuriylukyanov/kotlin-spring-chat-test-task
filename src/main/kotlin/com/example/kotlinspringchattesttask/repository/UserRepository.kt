package com.example.kotlinspringchattesttask.repository

import com.example.kotlinspringchattesttask.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface UserRepository: JpaRepository<User, UUID>  {
    fun existsByUsername(username: String): Boolean;
    fun findByIdIn(ids: List<UUID>): List<User>
}


