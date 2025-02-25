package com.dslegal.network.services.auth.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the request body for user registration.
 *
 * This data class encapsulates the necessary information required to
 * create a new user account. It includes
 * the user's first name, last name, email, password, and role.
 *
 * This class is designed to be serialized into JSON format for sending
 * as the body of an HTTP request to an authentication endpoint.
 *
 * The [SerialName] annotation is used to map the Kotlin property names
 * to the corresponding JSON keys, ensuring compatibility with the server's
 * expected format.
 *
 * @property firstName The first name of the user.
 * @property lastName The last name of the user.
 * @property email The email address of the user.
 * @property password The password of the user.
 * @property role The role of the user (e.g., "lawyer", "paralegal").
 */
@Serializable
data class RegisterRequestBody (
    @SerialName("first_name") val firstName: String,
    @SerialName("last_name") val lastName: String,
    @SerialName("email") val email: String,
    @SerialName("password") val password: String,
    @SerialName("role") val role: String
)