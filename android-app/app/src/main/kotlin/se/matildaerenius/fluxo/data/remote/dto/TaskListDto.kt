package se.matildaerenius.fluxo.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class TaskListDto(
    val id : String? = null,
    val title : String,
    val description : String? = null,
)