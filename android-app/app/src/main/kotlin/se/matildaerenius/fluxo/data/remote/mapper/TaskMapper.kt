package se.matildaerenius.fluxo.data.remote.mapper

import se.matildaerenius.fluxo.data.remote.dto.TaskDto
import se.matildaerenius.fluxo.domain.model.Task

fun TaskDto.toDomain(): Task {
    return Task(
        id = this.id ?: "",
        title = this.title,
        isCompleted = this.isCompleted,
        priority = this.priority
    )
}

fun Task.toDto(): TaskDto {
    return TaskDto(
        id = this.id.ifEmpty { null },
        title = this.title,
        isCompleted = this.isCompleted,
        priority = this.priority
    )
}