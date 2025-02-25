package com.dslegal.network.services.auth.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponseBody(
    @SerialName("user") val userDTO: UserDTO,
    @SerialName("message") val message: String,
    @SerialName("tokens") val tokens: TokenDTO
)
