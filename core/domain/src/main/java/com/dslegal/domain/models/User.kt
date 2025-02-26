package com.dslegal.domain.models

data class User(
    val email: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    val role: String
)
