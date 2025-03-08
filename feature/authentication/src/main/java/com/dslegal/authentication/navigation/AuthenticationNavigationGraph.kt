package com.dslegal.authentication.navigation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.dslegal.authentication.BaseViewModel
import com.dslegal.authentication.RegisterUiEvent
import com.dslegal.authentication.ui.AuthenticationScreensWrapper
import com.dslegal.authentication.ui.LoginScreen
import com.dslegal.authentication.ui.SignupScreen
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject
import org.koin.java.KoinJavaComponent.inject

fun NavGraphBuilder.authenticationNavGraph(
    authenticationNavigator: AuthenticationNavigator,
    route: String,
    snackBarHostState: SnackbarHostState
) {
    navigation(
        startDestination = AuthenticationScreen.SignUp.route,
        route = route
    ) {
        val sharedViewModel:BaseViewModel by inject(BaseViewModel::class.java)

        composable(route = AuthenticationScreen.Login.route) {

            AuthenticationScreensWrapper(
                viewModel = sharedViewModel,
                navigator = authenticationNavigator,
                snackBarHostState = snackBarHostState
            ) { state, onEvent, onNavigate ->
                LoginScreen(
                    state = state,
                    onNavigate = onNavigate,
                    onEvent = onEvent
                )
            }
        }

        composable(route = AuthenticationScreen.SignUp.route) {

            AuthenticationScreensWrapper(
                viewModel = sharedViewModel,
                navigator = authenticationNavigator,
                snackBarHostState = snackBarHostState
            ) { state, onEvent, onNavigate ->
                SignupScreen(
                    state = state,
                    onNavigate = onNavigate,
                    onEvent = onEvent
                )
            }
        }
    }
}
