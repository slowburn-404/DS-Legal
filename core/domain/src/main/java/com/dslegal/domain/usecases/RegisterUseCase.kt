package com.dslegal.domain.usecases


import com.dslegal.domain.repositories.AuthenticationRepository
import com.dslegal.domain.repositories.TokenRepository

interface RegisterUseCase {
    suspend operator fun invoke()
}

internal class RegisterUseCaseImpl(
    private val authenticationRepository: AuthenticationRepository,
    private val tokenRepository: TokenRepository
) : RegisterUseCase {
    override suspend operator fun invoke() {
        TODO("Not yet implemented")
    }
}