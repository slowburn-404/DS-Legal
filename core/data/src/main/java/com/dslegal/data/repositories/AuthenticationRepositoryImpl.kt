package com.dslegal.data.repositories

import com.dslegal.common.DispatcherProvider
import com.dslegal.data.toDomain
import com.dslegal.data.toLoginBody
import com.dslegal.data.toRegisterBody
import com.dslegal.domain.models.DomainResponse
import com.dslegal.domain.models.User
import com.dslegal.domain.repositories.AuthenticationRepository
import com.dslegal.network.model.NetworkResponse
import com.dslegal.network.services.auth.UserApiService
import kotlinx.coroutines.withContext


internal class AuthenticationRepositoryImpl(
    private val userApiService: UserApiService,
    private val coroutineDispatcher: DispatcherProvider
) : AuthenticationRepository {
    override suspend fun signUp(user: User): DomainResponse<User> {
        return withContext(coroutineDispatcher.ioDispatcher) {
            when (val networkResult = userApiService.register(user.toRegisterBody())) {
                is NetworkResponse.Success -> DomainResponse.Success(networkResult.data.userDTO.toDomain())
                is NetworkResponse.Fail -> DomainResponse.Error(networkResult.error.message)
            }
        }
    }

    override suspend fun login(user: User): DomainResponse<User> {
        return withContext(coroutineDispatcher.ioDispatcher) {
            when (val networkResult = userApiService.login(user.toLoginBody())) {
                is NetworkResponse.Success -> DomainResponse.Success(networkResult.data.userDTO.toDomain())
                is NetworkResponse.Fail -> DomainResponse.Error(networkResult.error.message)

            }
        }
    }

    override suspend fun logout(): DomainResponse<Unit> {
        return withContext(coroutineDispatcher.ioDispatcher) {
            when (val networkResult = userApiService.logout()) {
                is NetworkResponse.Success -> DomainResponse.Success(Unit)
                is NetworkResponse.Fail -> DomainResponse.Error(networkResult.error.message)
            }
        }
    }

}