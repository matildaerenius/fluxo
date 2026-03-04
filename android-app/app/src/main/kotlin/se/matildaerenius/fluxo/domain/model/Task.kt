package se.matildaerenius.fluxo.domain.model

data class Task(
    val id: String,
    val title: String,
    val isCompleted: Boolean,
    val priority: Int
)
