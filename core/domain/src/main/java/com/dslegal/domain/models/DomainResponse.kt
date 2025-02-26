package com.dslegal.domain.models

sealed interface DomainResponse<out T> {
    data class Success<T>(val data: T): DomainResponse<T>
    data class Error(val message: String): DomainResponse<Nothing>
}