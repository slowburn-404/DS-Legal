package com.dslegal.authentication.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class AuthenticationScreen(
    val route: String,
    val title: String
) {
    @Serializable
    data object Login : AuthenticationScreen(
        route = "login_screen",
        title = "Login"
    )

    @Serializable
    data object SignUp : AuthenticationScreen(
        route = "signup_screen",
        title = "SignUp"
    )
}