package com.dslegal.domain.usecases

import com.dslegal.domain.models.DomainResponse
import com.dslegal.domain.models.User
import com.dslegal.domain.repositories.AuthenticationRepository

interface RegisterUseCase {
    suspend operator fun invoke(user: User): DomainResponse<String>
}

internal class RegisterUseCaseImpl(
    private val authenticationRepository: AuthenticationRepository,
) : RegisterUseCase {
    override suspend operator fun invoke(user: User): DomainResponse<String> {
        return when (val response = authenticationRepository.signUp(user)) {
            is DomainResponse.Success -> {
                DomainResponse.Success("User created successfully")
            }

            is DomainResponse.Error -> {
                DomainResponse.Error(response.message)
            }
        }
    }
}