package com.dslegal.authentication

import androidx.core.util.PatternsCompat.EMAIL_ADDRESS
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dslegal.authentication.navigation.AuthenticationScreen
import com.dslegal.domain.models.DomainResponse
import com.dslegal.domain.usecases.RegisterUseCase
import com.dslegal.domain.usecases.VerifyEmailUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class BaseViewModel(
    //private val registerUseCase: RegisterUseCase,
    private val verifyEmailUseCase: VerifyEmailUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(RegisterUiState())
    val state: StateFlow<RegisterUiState> = _state.asStateFlow()


    private val _uiEvent: MutableSharedFlow<RegisterUiEvent> = MutableSharedFlow()
    val uiEvent: SharedFlow<RegisterUiEvent> = _uiEvent.asSharedFlow()


    init {
        viewModelScope.launch {
            uiEvent.collect { event ->
                when (event) {
                    is RegisterUiEvent.EnterEmail -> {
                        enterEmail(event.email)
                    }

                    is RegisterUiEvent.ShowSnackBar -> {
                        showSnackBar(event.message)
                    }

                    else -> {}
                }
            }
        }
    }


    fun emitEvent(uiEvent: RegisterUiEvent) =
        viewModelScope.launch {
            _uiEvent.emit(uiEvent)
        }

    private suspend fun verifyEmail(email: String) {
        showLoadingIndicator(true)
        when (val response = verifyEmailUseCase(email)) {
            is DomainResponse.Success -> {
                _state.update { currentState ->
                    currentState.copy(
                        isLoading = false,
                        errorMessage = "",
                        emailError = ""
                    )
                }

                showLoadingIndicator(false)
                _uiEvent.emit(RegisterUiEvent.EmailVerificationSuccessful)

            }

            is DomainResponse.Error -> {
                _state.update { currentState ->
                    currentState.copy(
                        isLoading = false,
                        errorMessage = response.message,
                        emailError = response.message
                    )
                }

                showLoadingIndicator(false)

                showSnackBar(response.message)
            }
        }
    }

    private fun showSnackBar(message: String) {
        _uiEvent.tryEmit(RegisterUiEvent.ShowSnackBar(message))
    }

    private fun enterEmail(email: String) {
        _state.update { currentState ->
            currentState.copy(
                user = currentState.user.copy(
                    email = email
                )
            )
        }
        validateEmail()
    }

    private fun validateEmail() {
        val email = _state.value.user.email
        val isEmailValid = EMAIL_ADDRESS.matcher(email).matches()

        _state.update { currentState ->
            currentState.copy(
                isEmailValid = isEmailValid,
                emailError = if (isEmailValid) "" else "Invalid email"
            )
        }
    }

    private fun showLoadingIndicator(isLoading: Boolean) {
        _state.update { currentState ->
            currentState.copy(
                isLoading = isLoading
            )
        }
    }
}
