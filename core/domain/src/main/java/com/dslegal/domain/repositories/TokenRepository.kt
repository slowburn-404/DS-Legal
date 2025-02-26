package com.dslegal.domain.repositories

import kotlinx.coroutines.flow.Flow

/**
 * Interface for interacting with a token repository.
 *
 * This interface defines the contract for retrieving and saving access and refresh tokens.
 * It provides a way to observe changes to the tokens and to save new tokens.
 *
 * The tokens are represented as [Flow]s, allowing for asynchronous observation
 * of changes to the token values. This is useful for reacting to token
 * updates in real-time.
 */
interface TokenRepository {

    /**
     * A [Flow] representing the current access token.
     *
     * This flow emits the current access token whenever it changes.
     * It may emit `null` if no access token is currently available.
     */
    val accessToken: Flow<String?>

    /**
     * A [Flow] representing the current refresh token.
     *
     * This flow emits the current refresh token whenever it changes.
     * It may emit `null` if no refresh token is currently available.
     */
    val refreshToken: Flow<String?>

    /**
     * Saves the provided access and refresh tokens.
     *
     * This method is responsible for storing the given access and refresh
     * tokens securely. It should update the values emitted by the
     * [accessToken] and [refreshToken] flows.
     *
     * @param accessToken The access token to save.
     * @param refreshToken The refresh token to save.
     */
    suspend fun saveToken(
        accessToken: String,
        refreshToken: String
    )
}