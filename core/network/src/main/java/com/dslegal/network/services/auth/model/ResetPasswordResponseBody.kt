package com.dslegal.network.services.auth.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResetPasswordResponseBody(
    @SerialName("user") val userDTO: UserDTO,
    @SerialName("password_version") val passwordVersion: Int,
    @SerialName("message") val message: String,
)