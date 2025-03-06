package com.dslegal.authentication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dslegal.domain.usecases.RegisterUseCase
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
    private val registerUseCase: RegisterUseCase
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
                }
            }
        }
    }


    fun emitEvent(uiEvent: RegisterUiEvent) =
        viewModelScope.launch {
            _uiEvent.emit(uiEvent)
        }

    private fun enterEmail(email: String) {
        _state.update { currentState ->
            currentState.copy(
                user = currentState.user.copy(
                    email = email
                )
            )
        }
    }
}
