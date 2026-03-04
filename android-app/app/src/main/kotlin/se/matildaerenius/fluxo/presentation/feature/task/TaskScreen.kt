package se.matildaerenius.fluxo.presentation.feature.task

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import se.matildaerenius.fluxo.presentation.common.UiStateContent
import se.matildaerenius.fluxo.presentation.feature.task.components.TaskItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskScreen(
    viewModel: TaskViewModel,
    onBackClick: () -> Unit
) {
    val uiState by viewModel.state.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Uppgifter") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Tillbaka")
                    }
                }
            )
        }
    ) { padding ->
        UiStateContent(
            state = uiState,
            onRetry = { viewModel.loadTasks() }
        ) { tasks ->
            if (tasks.isEmpty()) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.Center) {
                    Text("Inga uppgifter här än!")
                }
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding),
                    contentPadding = PaddingValues(16.dp)
                ) {
                    items(tasks) { task ->
                        TaskItem(
                            task = task,
                            onStatusChange = { /*  FIXA */ }
                        )
                    }
                }
            }
        }
    }
}