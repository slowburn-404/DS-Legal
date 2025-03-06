package com.dslegal.authentication.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.dslegal.authentication.BaseViewModel
import com.dslegal.authentication.RegisterUiEvent
import com.dslegal.authentication.ui.LoginScreen
import com.dslegal.authentication.ui.SignupScreen
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.AuthenticationNavGraph(
    authenticationNavigator: AuthenticationNavigator,
    route: String
) {
    navigation(
        startDestination = AuthenticationScreen.Login.route,
        route = route
    ) {

        composable(route = AuthenticationScreen.Login.route) {
            val viewModel = koinViewModel<BaseViewModel>()
            val loginState by viewModel.state.collectAsStateWithLifecycle()
            val loginUiEvent by viewModel.uiEvent.collectAsStateWithLifecycle(
                initialValue = RegisterUiEvent.EnterEmail(
                    ""
                )
            )

            LoginScreen(
                state = loginState,
                uiEvent = loginUiEvent,
                onNavigate = { screen ->
                    authenticationNavigator.navigateToScreen(screen)
                },
                onEvent = { event ->
                    viewModel.emitEvent(event)
                }

            )
        }

        composable(route = AuthenticationScreen.SignUp.route) {
            val viewModel = koinViewModel<BaseViewModel>()
            val loginState by viewModel.state.collectAsStateWithLifecycle()
            val loginUiEvent by viewModel.uiEvent.collectAsStateWithLifecycle(
                initialValue = RegisterUiEvent.EnterEmail(
                    ""
                )
            )

            SignupScreen(
                state = loginState,
                uiEvent = loginUiEvent,
                onNavigate = { screen ->
                    authenticationNavigator.navigateToScreen(screen)
                },
                onEvent = { event ->
                    viewModel.emitEvent(event)
                }
            )
        }
    }
}
