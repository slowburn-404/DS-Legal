package com.dslegal.network.services.auth.model

import kotlinx.serialization.Serializable

@Serializable
data class ForgotPasswordResponseBody(
    val message: String
)
