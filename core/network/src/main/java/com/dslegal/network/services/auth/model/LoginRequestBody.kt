package com.dslegal.network.services.auth.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class LoginRequestBody(
    @SerialName("email") val email: String,
    @SerialName("password") val password: String
)
