package com.example.composestartandroid.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

/**
 * Lesson 12
 */
@Composable
internal fun CounterScreen(counterViewModel: CounterViewModel = viewModel()) {

    /**
     * collectAsState - подписывается на StateFlow и предоставляет State.
     * collectAsStateWithLifecycle - можно использовать если есть тяжелый flow
     */
    val uiState by counterViewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ClickCounter(counter = uiState.count) {
            counterViewModel.onCounterClick()
        }
        EnableFeature(enabled = uiState.enabled, onEnabledChange = {
            counterViewModel.setEnabled(it)
        })
    }
}

@Composable
private fun ClickCounter(
    counter: Int,
    onClickCounter: () -> Unit,
) {
    Text(
        text = "Clicks: $counter",
        modifier = Modifier.clickable(onClick = { onClickCounter() })
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnableFeature(
    enabled: Boolean,
    onEnabledChange: (Boolean) -> Unit
) {
    Row(verticalAlignment = CenterVertically) {
        Checkbox(checked = enabled, onCheckedChange = onEnabledChange)
        Text("enable feature")
    }
}