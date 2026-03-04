package se.matildaerenius.fluxo.presentation.feature.tasklist

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import se.matildaerenius.fluxo.presentation.common.UiStateContent
import se.matildaerenius.fluxo.presentation.feature.tasklist.components.TaskListItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskListScreen(
    viewModel: TaskListViewModel,
    onListClick: (String) -> Unit
) {
    val uiState by viewModel.state.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mina Listor") }
            )
        }
    ) { padding ->
        UiStateContent(
            state = uiState,
            onRetry = { viewModel.getTaskLists() }
        ) { lists ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(lists) { list ->
                    TaskListItem(
                        taskList = list,
                        onClick = { onListClick(list.id) }
                    )
                }
            }
        }
    }
}