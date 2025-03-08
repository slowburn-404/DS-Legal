package com.dslegal.authentication

import androidx.compose.runtime.Stable
import com.dslegal.domain.models.User

@Stable
data class RegisterUiState(
    val user: User = User(
        "",
        "",
        "",
        "",
        ""
    ),
    val isLoading: Boolean = false,
    val errorMessage: String= "",
    val isEmailValid: Boolean = false,
    val emailError: String = ""
)
