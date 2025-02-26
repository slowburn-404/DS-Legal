package com.dslegal.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import com.dslegal.datastore.utils.TokenPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

/**
 * Interface for managing access and refresh tokens.
 *
 * This interface defines the contract for storing, retrieving, and managing
 * access and refresh tokens used for authentication. It provides a way to
 * observe changes to the tokens and to save new tokens.
 *
 * The tokens are represented as [Flow]s, allowing for asynchronous observation
 * of changes to the token values. This is useful for reacting to token
 * updates in real-time.
 */
interface TokenManager {

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
    suspend fun saveToken(accessToken: String, refreshToken: String)
}


internal class TokenManagerImpl(
    private val preferenceDataStore: DataStore<Preferences>
) : TokenManager {
    override val accessToken: Flow<String?>
        get() =
            preferenceDataStore.data
                .catch { exception ->
                    if (exception is IOException) {
                        exception.printStackTrace()
                        emit(emptyPreferences())
                    } else {
                        throw exception
                    }
                }.map { preferences ->
                    preferences[TokenPreferences.ACCESS_TOKEN_KEY] ?: ""
                }


    override val refreshToken: Flow<String?>
        get() =
            preferenceDataStore.data
                .catch { exception ->
                    if (exception is IOException) {
                        exception.printStackTrace()
                        emit(emptyPreferences())
                    } else {
                        throw exception
                    }
                }.map { preferences ->
                    preferences[TokenPreferences.REFRESH_TOKEN_KEY] ?: ""
                }

    override suspend fun saveToken(
        accessToken: String,
        refreshToken: String
    ) {
        preferenceDataStore.edit { preferences ->
            preferences[TokenPreferences.ACCESS_TOKEN_KEY] = accessToken
            preferences[TokenPreferences.ACCESS_TOKEN_KEY] = refreshToken
        }
    }
}