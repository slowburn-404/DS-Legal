package com.dslegal.authentication.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dslegal.authentication.RegisterUiEvent
import com.dslegal.authentication.RegisterUiState
import com.dslegal.authentication.navigation.AuthenticationScreen


@Composable
fun LoginScreen(
    state: RegisterUiState,
    uiEvent: RegisterUiEvent,
    onNavigate: (AuthenticationScreen) -> Unit,
    onEvent: (RegisterUiEvent) -> Unit
) {
    LaunchedEffect(uiEvent) {
        when (uiEvent) {
            is RegisterUiEvent.EnterEmail -> {
                onEvent(
                    RegisterUiEvent.EnterEmail(
                        uiEvent.email
                    )
                )
            }
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("DS Legal")


    }
}


@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen()
}