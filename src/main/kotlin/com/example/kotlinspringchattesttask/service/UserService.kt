package com.example.kotlinspringchattesttask.service

import com.example.kotlinspringchattesttask.dto.AddUser
import com.example.kotlinspringchattesttask.entity.User
import com.example.kotlinspringchattesttask.exception.BadRequestException
import com.example.kotlinspringchattesttask.repository.UserRepository
import org.springframework.stereotype.Service
import java.time.OffsetDateTime
import java.util.*

@Service
class UserService(val repository: UserRepository) {
    fun createUser(dto: AddUser): UUID {
        if(dto.username.isNullOrEmpty()) {
            throw BadRequestException("empty username")
        }
        if (!repository.existsByUsername(dto.username)){
            val user = User(
                UUID.randomUUID(),
                dto.username,
                OffsetDateTime.now()
            );
            repository.save(user);
            return user.id;
        } else {
            throw BadRequestException("username " + dto.username + " already exists");
        }
    }
}