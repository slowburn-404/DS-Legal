package com.dslegal.authentication

import com.dslegal.authentication.navigation.AuthenticationScreen

sealed interface RegisterUiEvent {
    data class EnterEmail(val email: String): RegisterUiEvent
    data class ShowSnackBar(val message: String): RegisterUiEvent
    //data class Navigate(val screen: AuthenticationScreen): RegisterUiEvent
    data object EmailVerificationSuccessful: RegisterUiEvent
}