package com.dslegal.domain.repositories

import com.dslegal.domain.models.DomainResponse
import com.dslegal.domain.models.User

/**
 * Interface defining the contract for authentication-related operations.
 *
 * This interface outlines the methods available for managing user authentication,
 * including signing up, logging in, and logging out. It acts as an abstraction
 * layer between the data layer and the domain/presentation layer, providing
 * a clean way to interact with authentication logic.
 *
 * Each method in this interface is a suspend function, indicating that it
 * can be used within a coroutine and may perform long-running operations
 * such as network requests or database interactions.
 *
 * All methods return a [DomainResponse], which encapsulates either a
 * successful response with the corresponding data or a failure with an
 * [Error] containing details about the error.
 */
interface AuthenticationRepository {

    /**
     * Registers a new user.
     *
     * This method handles the process of creating a new user account.
     * It takes a [User] object containing the user's details and returns
     * a [DomainResponse] indicating the success or failure of the operation.
     *
     * @param user The [User] object containing the user's registration details.
     * @return A [DomainResponse] containing either:
     *         - [DomainResponse.Success] with the registered [User] if the registration is successful.
     *         - [DomainResponse.Fail] with an [Error] if the registration fails.
     */
    suspend fun signUp(user: User): DomainResponse<User>

    /**
     * Logs in an existing user.
     *
     * This method handles the process of authenticating a user and
     * establishing a login session. It takes a [User] object containing
     * the user's login credentials and returns a [DomainResponse]
     * indicating the success or failure of the operation.
     *
     * @param user The [User] object containing the user's login credentials.
     * @return A [DomainResponse] containing either:
     *         - [DomainResponse.Success] with the logged-in [User] if the login is successful.
     *         - [DomainResponse.Fail] with an [Error] if the login fails.
     */
    suspend fun login(user: User): DomainResponse<User>

    /**
     * Logs out the currently authenticated user.
     *
     * This method handles the process of terminating the user's current
     * login session. It does not return any data, but a [DomainResponse.Error]
     * will be returned if the logout fails.
     *
     * @return A [DomainResponse] containing either:
     *         - [DomainResponse.Success] if the logout is successful.
     *         - [DomainResponse.Fail] with an [Error] if the logout fails.
     */
    suspend fun logout(): DomainResponse<Unit>


    suspend fun verifyEmail(email: String): DomainResponse<String>


    suspend fun forgotPassword(email: String): DomainResponse<String>

    suspend fun resetPassword(newPassword: String, token: String): DomainResponse<String>
}