package se.matildaerenius.fluxo.domain.model

data class Task(
    val id: String,
    val title: String,
    val description: String?,
    val dueDate: String?,
    val status: TaskStatus,
    val priority: TaskPriority
)