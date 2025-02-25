package com.dslegal.network.services.auth.model

import kotlinx.serialization.SerialName

/**
 * Represents the response body returned after a successful authentication attempt.
 *
 * This data class encapsulates the information sent back from the server
 * upon successful user registration. It includes the user's details
 * as a [UserDTO] and a message confirming the success of the authentication.
 *
 * The class is designed to be used with Kotlin Serialization, allowing it to be
 * easily converted to and from JSON format for network communication.
 *
 * @property userDTO The [UserDTO] containing the details of the authenticated user.
 * @property message A message indicating the success of the authentication process.
 *                   This could be a simple confirmation like "Login successful" or
 *                   "User registered successfully".
 */
data class RegisterResponseBody(
    @SerialName("user") val userDTO: UserDTO,
    @SerialName("message") val message: String
)