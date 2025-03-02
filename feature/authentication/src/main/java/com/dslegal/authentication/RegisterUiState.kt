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
    val errorMessage: String= ""
)
