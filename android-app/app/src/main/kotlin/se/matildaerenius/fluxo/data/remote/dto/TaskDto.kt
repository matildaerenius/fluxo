package se.matildaerenius.fluxo.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class TaskDto(
    val id: String? = null,
    val title: String,
    val description: String? = null,
    val dueDate: String? = null,
    val status: String = "OPEN",
    val priority: String = "MEDIUM"
)