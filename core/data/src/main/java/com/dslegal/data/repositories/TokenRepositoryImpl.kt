package com.dslegal.data.repositories

import com.dslegal.common.DispatcherProvider
import com.dslegal.datastore.TokenManager
import com.dslegal.domain.repositories.TokenRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext


class TokenRepositoryImpl(
    private val tokenManager: TokenManager,
    private val coroutineDispatcher: DispatcherProvider
) : TokenRepository {
    override val accessToken: Flow<String?>
        get() = tokenManager.accessToken

    override val refreshToken: Flow<String?>
        get() = tokenManager.refreshToken

    override suspend fun saveToken(accessToken: String, refreshToken: String) {
        withContext(coroutineDispatcher.ioDispatcher) {
            tokenManager.saveToken(
                accessToken = accessToken,
                refreshToken = refreshToken
            )
        }
    }
}