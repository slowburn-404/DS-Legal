package com.dslegal.domain.repository

interface AuthRepository {

    suspend fun register()

    suspend fun login()

    suspend fun logout()
}