package com.dslegal.network.services.auth.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data Transfer Object (DTO) representing a user.
 *
 * This class is used to transfer user data when communicating with a server.
 * It encapsulates the essential information about a user, including their unique identifier,
 * name, email, password, role, and timestamps for creation and updates.
 *
 * The class is annotated with [Serializable] to enable serialization and deserialization,
 * which is useful for tasks like sending user data over a network or storing it in a database.
 *
 * Each property is annotated with [SerialName] to specify the JSON key name during serialization.
 * This allows for flexibility in naming conventions between the Kotlin code and the external data format.
 *
 * @property id The unique identifier of the user.
 * @property firstName The first name of the user.
 * @property lastName The last name of the user.
 * @property email The email address of the user.
 * @property password The password of the user.
 * @property role The role of the user (e.g., "admin", "user").
 * @property updatedAt The timestamp indicating when the user's information was last updated.
 * @property createdAt The timestamp indicating when the user was created.
 */

@Serializable
data class UserDTO(
    @SerialName("id") val id: String,
    @SerialName("first_name") val firstName: String,
    @SerialName("last_name") val lastName: String,
    @SerialName("email") val email: String,
    @SerialName("role") val role: String,
    @SerialName("updated_at") val updatedAt: String,
    @SerialName("created_at") val createdAt: String
)
