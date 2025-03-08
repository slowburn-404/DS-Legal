package com.dslegal.domain.usecases

import com.dslegal.domain.models.DomainResponse
import com.dslegal.domain.repositories.AuthenticationRepository

interface VerifyEmailUseCase {
    suspend operator fun invoke(email: String): DomainResponse<String>
}

class VerifyEmailUseCaseImpl(
    private val authenticationRepository: AuthenticationRepository
) : VerifyEmailUseCase {
    override suspend operator fun invoke(email: String): DomainResponse<String> {

        return try {
            val response = authenticationRepository.verifyEmail(email)

            if (response is DomainResponse.Error) {
                DomainResponse.Error(response.message)
            }

            DomainResponse.Success(response.toString())
        } catch (exception: Exception) {
            exception.printStackTrace()
            DomainResponse.Error("Unexpected error")
        }
    }
}