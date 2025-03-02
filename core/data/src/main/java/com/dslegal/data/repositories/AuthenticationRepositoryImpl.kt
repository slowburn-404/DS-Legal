package com.dslegal.data.repositories

import com.dslegal.common.DispatcherProvider
import com.dslegal.data.mappers.toDomain
import com.dslegal.data.mappers.toLoginBody
import com.dslegal.data.mappers.toRegisterBody
import com.dslegal.domain.models.DomainResponse
import com.dslegal.domain.models.User
import com.dslegal.domain.repositories.AuthenticationRepository
import com.dslegal.network.model.NetworkResponse
import com.dslegal.network.services.auth.UserApiService
import com.dslegal.data.mappers.toForgotPasswordRequestBody
import com.dslegal.data.mappers.toResetPasswordRequestBody
import kotlinx.coroutines.withContext


internal class AuthenticationRepositoryImpl(
    private val userApiService: UserApiService,
    private val coroutineDispatcher: DispatcherProvider
) : AuthenticationRepository {
    override suspend fun signUp(user: User): DomainResponse<User> {
        return withContext(coroutineDispatcher.ioDispatcher) {
            when (val networkResult = userApiService.register(user.toRegisterBody())) {
                is NetworkResponse.Success -> DomainResponse.Success(networkResult.data.userDTO.toDomain())
                is NetworkResponse.Fail<*> -> DomainResponse.Error(networkResult.error.toString())
            }
        }
    }

    override suspend fun login(user: User): DomainResponse<User> {
        return withContext(coroutineDispatcher.ioDispatcher) {
            when (val networkResult = userApiService.login(user.toLoginBody())) {
                is NetworkResponse.Success -> DomainResponse.Success(networkResult.data.userDTO.toDomain())
                is NetworkResponse.Fail<*> -> DomainResponse.Error(networkResult.error.toString())

            }
        }
    }

    override suspend fun logout(): DomainResponse<Unit> {
        return withContext(coroutineDispatcher.ioDispatcher) {
            when (val networkResult = userApiService.logout()) {
                is NetworkResponse.Success -> DomainResponse.Success(Unit)
                is NetworkResponse.Fail<*> -> DomainResponse.Error(networkResult.error.toString())
            }
        }
    }

    override suspend fun verifyEmail(email: String): DomainResponse<String> {
        return withContext(coroutineDispatcher.ioDispatcher) {
            when (val networkResult = userApiService.verifyEmail(email)) {
                is NetworkResponse.Success -> DomainResponse.Success(networkResult.data.message)
                is NetworkResponse.Fail<*> -> DomainResponse.Error(networkResult.error.toString())
            }
        }
    }

    override suspend fun forgotPassword(email: String): DomainResponse<String> {
        return withContext(coroutineDispatcher.ioDispatcher) {
            when (val networkResult = userApiService.forgotPassword(email.toForgotPasswordRequestBody())) {
                is NetworkResponse.Success -> DomainResponse.Success(networkResult.data.message)
                is NetworkResponse.Fail<*> -> DomainResponse.Error(networkResult.error.toString())
            }
        }
    }

    override suspend fun resetPassword(newPassword: String, token: String): DomainResponse<String> {
        return withContext(coroutineDispatcher.ioDispatcher) {
            when(val networkResult = userApiService.resetPassword(newPassword.toResetPasswordRequestBody(), token)) {
                is NetworkResponse.Success -> DomainResponse.Success(networkResult.data.message)
                is NetworkResponse.Fail<*> -> DomainResponse.Error(networkResult.error.toString())
            }
        }
    }

}