package com.dslegal.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the error body returned from a failed network request.
 *
 * This data class encapsulates the error information, including the status,
 * status code, and message.
 *
 * The class is designed to be used with Kotlin Serialization, allowing it to be
 * easily converted to and from JSON format for network communication.
 *
 * @property status A string representing the status of the error.
 *                  This could be a general error category like "error" or "failure".
 * @property statusCode An integer representing the HTTP status code of the error.
 *                      For example, 404 for "Not Found" or 500 for "Internal Server Error".
 * @property message A string containing the error message.
 *                  This message should provide more specific details about the error.
 */
@Serializable
data class ErrorBody(
    @SerialName("status") val status: String,
    @SerialName("statusCode") val statusCode: Int,
    @SerialName("message") val message: String
)