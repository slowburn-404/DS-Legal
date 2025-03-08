package com.dslegal.authentication.navigation

import androidx.navigation.NavHostController

interface AuthenticationNavigator {
    fun navigateUp()

    fun navigateToScreen(screen: AuthenticationScreen)
}

internal class AuthenticationNavigatorImpl(
    private val navController: NavHostController
) : AuthenticationNavigator {
    override fun navigateUp() {
        navController.navigateUp()
    }

    override fun navigateToScreen(screen: AuthenticationScreen) {
        when(screen) {
            is AuthenticationScreen.Login -> {
                navigateToLogin()
            }
            is AuthenticationScreen.SignUp -> {
                navigateToSignUp()
            }
        }
    }

    private fun navigateToLogin() {
        navController.navigate(AuthenticationScreen.Login.route) {
            popUpTo(AuthenticationScreen.Login.route) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }

    private fun navigateToSignUp() {
        navController.navigate(AuthenticationScreen.SignUp.route) {
            popUpTo(AuthenticationScreen.SignUp.route) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }

}