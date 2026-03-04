package se.matildaerenius.fluxo.data.remote.mapper

import se.matildaerenius.fluxo.data.remote.dto.TaskDto
import se.matildaerenius.fluxo.domain.model.Task
import se.matildaerenius.fluxo.domain.model.TaskStatus
import se.matildaerenius.fluxo.domain.model.TaskPriority

fun TaskDto.toDomain(): Task {
    return Task(
        id = this.id ?: "",
        title = this.title,
        description = this.description,
        dueDate = this.dueDate,
        status = runCatching { TaskStatus.valueOf(this.status) }.getOrDefault(TaskStatus.OPEN),
        priority = runCatching { TaskPriority.valueOf(this.priority) }.getOrDefault(TaskPriority.MEDIUM)
    )
}

fun Task.toDto(): TaskDto {
    return TaskDto(
        id = this.id.ifEmpty { null },
        title = this.title,
        description = this.description,
        dueDate = this.dueDate,
        status = this.status.name,
        priority = this.priority.name
    )
}