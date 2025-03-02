package com.dslegal.network.services.auth.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForgotPasswordRequestBody(
    @SerialName("email") val email: String
)