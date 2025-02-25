package com.dslegal.data.repositories

import com.dslegal.data.repositories.models.User
import com.dslegal.network.services.auth.UserApiService

interface AuthenticationRepository {
    suspend fun signUp(user: User)

    suspend fun login(user: User)

    suspend fun logout()
}

internal class AuthenticationRepositoryImpl(
    private val userApiService: UserApiService
): AuthenticationRepository {
    override suspend fun signUp(user: User){
        userApiService.register(user)
    }

    override suspend fun login(user: User) {
        userApiService.login(user: User)
    }

    override suspend fun logout() {
        userApiService.logout()
    }


}