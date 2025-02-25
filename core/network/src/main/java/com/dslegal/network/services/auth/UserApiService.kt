package com.dslegal.network.services.auth

import com.dslegal.network.model.ErrorBody
import com.dslegal.network.services.auth.model.RegisterResponseBody
import com.dslegal.network.model.NetworkResponse
import com.dslegal.network.services.auth.mappers.toErrorBody
import com.dslegal.network.services.auth.model.LoginRequestBody
import com.dslegal.network.services.auth.model.LoginResponseBody
import com.dslegal.network.services.auth.model.LogoutResponseBody
import com.dslegal.network.services.auth.model.RegisterRequestBody
import com.dslegal.network.util.URL.DELETE_URL
import com.dslegal.network.util.URL.LOGIN_URL
import com.dslegal.network.util.URL.LOGOUT_URL
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.isSuccess

/**
 * Interface defining the contract for user-related API operations.
 *
 * This interface outlines the methods available for interacting with the
 * user management portion of the API. It includes operations for user
 * registration, login, and logout.
 *
 * Each method in this interface is a suspend function, indicating that it
 * can be used within a coroutine and may perform long-running operations
 * such as network requests.
 *
 * All methods return a [NetworkResponse], which encapsulates either a
 * successful response with the corresponding data or a failure with an
 * [ErrorBody] containing details about the error.
 */
interface UserApiService {

    /**
     * Registers a new user.
     *
     * This method sends a request to the server to create a new user account.
     *
     * @param user The [RegisterRequestBody] containing the user's registration details.
     * @return A [NetworkResponse] containing either:
     *         - [NetworkResponse.Success] with [RegisterResponseBody] if the registration is successful.
     *         - [NetworkResponse.Fail] with [ErrorBody] if the registration fails.
     */
    suspend fun register(user: RegisterRequestBody): NetworkResponse<RegisterResponseBody>

    /**
     * Logs in an existing user.
     *
     * This method sends a request to the server to authenticate a user and
     * establish a login session.
     *
     * @param user The [LoginRequestBody] containing the user's login credentials.
     * @return A [NetworkResponse] containing either:
     *         - [NetworkResponse.Success] with [LoginResponseBody] if the login is successful.
     *         - [NetworkResponse.Fail] with [ErrorBody] if the login fails.
     */
    suspend fun login(user: LoginRequestBody): NetworkResponse<LoginResponseBody>

    /**
     * Logs out the currently authenticated user.
     *
     * This method sends a request to the server to terminate the user's
     * current login session.
     *
     * @return A [NetworkResponse] containing either:
     *         - [NetworkResponse.Success] with [LogoutResponseBody] if the logout is successful.
     *         - [NetworkResponse.Fail] with [ErrorBody] if the logout fails.
     */
    suspend fun logout(): NetworkResponse<LogoutResponseBody>
}

internal class UserApiServiceImpl(
    private val ktorClient: HttpClient,
) : UserApiService {
    override suspend fun register(user: RegisterRequestBody): NetworkResponse<RegisterResponseBody> {
        return try {
            val response = ktorClient.post(LOGOUT_URL) {
                setBody(user)
            }

            if (!response.status.isSuccess()) {
                NetworkResponse.Fail(
                    response.body<ErrorBody>()
                )
            }

            NetworkResponse.Success(response.body<RegisterResponseBody>())
        } catch (exception: Exception) {
            exception.printStackTrace()
            NetworkResponse.Fail(
                exception.toErrorBody()
            )
        }
    }

    override suspend fun login(user: LoginRequestBody): NetworkResponse<LoginResponseBody> {
        return try {
            val response = ktorClient.post(LOGIN_URL) {
                setBody(user)
            }

            if (!response.status.isSuccess()) {
                NetworkResponse.Fail(
                    response.body<ErrorBody>()
                )
            }

            NetworkResponse.Success(response.body<LoginResponseBody>())

        } catch (exception: Exception) {
            exception.printStackTrace()
            NetworkResponse.Fail(
                exception.toErrorBody()
            )
        }
    }

    override suspend fun logout(): NetworkResponse<LogoutResponseBody> {
        return try {
            val response = ktorClient.delete(DELETE_URL)

            if (!response.status.isSuccess()) {
                NetworkResponse.Fail(response.body<ErrorBody>())
            }

            NetworkResponse.Success(response.body<LogoutResponseBody>())
        } catch (exception: Exception) {
            exception.printStackTrace()
            NetworkResponse.Fail(
                exception.toErrorBody()
            )
        }
    }

}