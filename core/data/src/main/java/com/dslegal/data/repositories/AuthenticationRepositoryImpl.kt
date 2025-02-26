package com.dslegal.data.repositories

import com.dslegal.data.toDomain
import com.dslegal.data.toLoginBody
import com.dslegal.data.toRegisterBody
import com.dslegal.domain.models.DomainResponse
import com.dslegal.domain.models.User
import com.dslegal.domain.repository.AuthenticationRepository
import com.dslegal.network.model.NetworkResponse
import com.dslegal.network.services.auth.UserApiService


internal class AuthenticationRepositoryImpl(
    private val userApiService: UserApiService
) : AuthenticationRepository {
    override suspend fun signUp(user: User): DomainResponse<User> {
        return when (val networkResult = userApiService.register(user.toRegisterBody())) {
            is NetworkResponse.Success -> DomainResponse.Success(networkResult.data.userDTO.toDomain())
            is NetworkResponse.Fail -> DomainResponse.Error(networkResult.error.message)
        }
    }

    override suspend fun login(user: User): DomainResponse<User> {
        return when (val networkResult = userApiService.login(user.toLoginBody())) {
            is NetworkResponse.Success -> DomainResponse.Success(networkResult.data.userDTO.toDomain())
            is NetworkResponse.Fail -> DomainResponse.Error(networkResult.error.message)

        }
    }

    override suspend fun logout(): DomainResponse<Unit> {
        return when (val networkResult = userApiService.logout()) {
            is NetworkResponse.Success -> DomainResponse.Success(Unit)
            is NetworkResponse.Fail -> DomainResponse.Error(networkResult.error.message)
        }
    }

}