package com.example.composestartandroid.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CounterViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CounterScreenUIState())
    val uiState: StateFlow<CounterScreenUIState> = _uiState

    fun onCounterClick() {
        _uiState.update {
            it.copy(count = it.count + 1)
        }
    }

    fun setEnabled(enabled: Boolean) {
        _uiState.update {
            it.copy(
                enabled = enabled
            )
        }
    }
}