package se.matildaerenius.fluxo.presentation.feature.task.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import se.matildaerenius.fluxo.domain.model.Task
import se.matildaerenius.fluxo.domain.model.TaskPriority
import se.matildaerenius.fluxo.domain.model.TaskStatus

@Composable
fun TaskItem(
    task: Task,
    onStatusChange: (Task) -> Unit,
    modifier: Modifier = Modifier
) {
    val priorityColor = when (task.priority) {
        TaskPriority.HIGH -> Color.Red
        TaskPriority.MEDIUM -> Color.Yellow
        TaskPriority.LOW -> Color.Green
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = task.status == TaskStatus.CLOSED,
                onCheckedChange = { onStatusChange(task) }
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
            ) {
                Text(
                    text = task.title,
                    style = MaterialTheme.typography.titleMedium
                )
                task.description?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Surface(
                color = priorityColor.copy(alpha = 0.2f),
                shape = MaterialTheme.shapes.small
            ) {
                Text(
                    text = task.priority.name,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    style = MaterialTheme.typography.labelSmall,
                    color = priorityColor
                )
            }
        }
    }
}