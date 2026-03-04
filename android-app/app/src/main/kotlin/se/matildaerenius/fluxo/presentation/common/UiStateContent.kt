package se.matildaerenius.fluxo.presentation.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import se.matildaerenius.fluxo.presentation.state.UiState

@Composable
fun <T> UiStateContent(
    state: UiState<T>,
    onRetry: () -> Unit,
    content: @Composable (T) -> Unit
) {
    when (state) {
        is UiState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        is UiState.Error -> {
            ErrorStateView(
                message = state.message,
                onRetry = onRetry
            )
        }
        is UiState.Success -> {
            content(state.data)
        }
    }
}