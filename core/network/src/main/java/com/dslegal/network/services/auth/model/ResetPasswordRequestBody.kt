package com.dslegal.network.services.auth.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResetPasswordRequestBody(
    @SerialName("newPassword") val newPassword: String,
)
