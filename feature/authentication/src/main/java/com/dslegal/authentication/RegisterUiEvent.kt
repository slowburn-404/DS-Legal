package com.dslegal.authentication

sealed interface RegisterUiEvent {
    data class EnterEmail(val email: String): RegisterUiEvent
}