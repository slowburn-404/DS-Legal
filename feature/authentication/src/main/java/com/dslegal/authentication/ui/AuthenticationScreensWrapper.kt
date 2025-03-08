package com.dslegal.authentication.ui

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dslegal.authentication.BaseViewModel
import com.dslegal.authentication.RegisterUiEvent
import com.dslegal.authentication.RegisterUiState
import com.dslegal.authentication.navigation.AuthenticationNavigator
import com.dslegal.authentication.navigation.AuthenticationScreen

@Composable
fun AuthenticationScreensWrapper(
    viewModel: BaseViewModel,
    navigator: AuthenticationNavigator,
    snackBarHostState: SnackbarHostState,
    content: @Composable (
        state: RegisterUiState,
        onEvent: (RegisterUiEvent) -> Unit,
        onNavigate: (AuthenticationScreen) -> Unit
    ) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    //Handle Ui events
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
//                is RegisterUiEvent.Navigate -> {
//                    navigator.navigateToScreen(event.screen)
//                }

                is RegisterUiEvent.ShowSnackBar -> {
                    snackBarHostState.showSnackbar(
                        message = event.message
                    )
                }

                is RegisterUiEvent.EmailVerificationSuccessful -> {
                    navigator.navigateToScreen(AuthenticationScreen.Login)
                }

                else -> {} // handle business logic in the viewmodel(separation of concerns)

            }
        }
    }

    content(
        state,
        viewModel::emitEvent,
        navigator::navigateToScreen
    )
}