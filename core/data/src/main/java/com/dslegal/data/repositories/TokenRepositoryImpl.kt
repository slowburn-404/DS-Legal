package com.dslegal.data.repositories

import com.dslegal.datastore.TokenManager
import com.dslegal.domain.repositories.TokenRepository
import kotlinx.coroutines.flow.Flow


class TokenRepositoryImpl(private val  tokenManager: TokenManager) : TokenRepository {
    override val accessToken: Flow<String?>
        get() = tokenManager.accessToken

    override val refreshToken: Flow<String?>
        get() = tokenManager.refreshToken

    override suspend fun saveToken(accessToken: String, refreshToken: String) {
        tokenManager.saveToken(
            accessToken = accessToken,
            refreshToken = refreshToken
        )
    }
}