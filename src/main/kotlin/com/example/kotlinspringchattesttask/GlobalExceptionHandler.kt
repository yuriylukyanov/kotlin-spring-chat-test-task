package com.example.kotlinspringchattesttask

import com.example.kotlinspringchattesttask.exception.BadRequestException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {
	@ExceptionHandler(BadRequestException::class)
	fun customerNotFound(exception: BadRequestException) = ResponseEntity(exception.message, HttpStatus.BAD_REQUEST);
}