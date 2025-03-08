package com.dslegal.authentication.ui

sealed interface AuthenticationNavigationEvent {
    data object NavigateUp: AuthenticationNavigationEvent
    data object NavigateToLogin: AuthenticationNavigationEvent
    data object NavigateToSignUp: AuthenticationNavigationEvent
}