package com.dslegal.network.services.auth.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LogoutResponseBody(
    @SerialName("status") val status: String,
    @SerialName("message") val message: String
)
