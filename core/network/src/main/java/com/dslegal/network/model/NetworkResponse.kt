package com.dslegal.network.model

/**
 * A sealed interface representing the result of a network operation.
 *
 * This interface is used to encapsulate the outcome of a network request,
 * which can either be a success with data or a failure with an error.
 * It provides a type-safe way to handle both successful and failed
 * network responses.
 *
 * @param T The type of data returned in case of a successful response.
 */
sealed interface NetworkResponse<out T> {

    /**
     * Represents a successful network response.
     *
     * This data class holds the data returned from the network operation.
     *
     * @property data The data returned from the network operation.
     */
    data class Success<T>(val data: T) : NetworkResponse<T>

    /**
     * Represents a failed network response.
     *
     * This data class holds the error information in case of a network failure.
     *
     * @property error The error returned from the network operation.
     */
    data class Fail<T>(val error: T) : NetworkResponse<Nothing>
}