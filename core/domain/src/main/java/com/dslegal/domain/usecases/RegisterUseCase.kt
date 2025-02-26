package com.dslegal.domain.usecases


import com.dslegal.domain.repositories.AuthenticationRepository

interface RegisterUseCase {
    suspend operator fun invoke()
}

internal class RegisterUseCaseImpl(
    private val authenticationRepository: AuthenticationRepository,
) : RegisterUseCase {
    override suspend operator fun invoke() {
        TODO("Not yet implemented")
    }
}