package se.matildaerenius.fluxo.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class TaskDto(
    val id: String? = null,
    val title: String,
    val isCompleted: Boolean = false,
    val priority: Int = 1
)
