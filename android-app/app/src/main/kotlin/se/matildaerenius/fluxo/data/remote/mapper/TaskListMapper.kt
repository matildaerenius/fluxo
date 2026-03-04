package se.matildaerenius.fluxo.data.remote.mapper

import se.matildaerenius.fluxo.data.remote.dto.TaskListDto
import se.matildaerenius.fluxo.domain.model.TaskList

fun TaskListDto.toDomain(): TaskList {
    return TaskList(
        id = this.id ?: "",
        title = this.title,
        description = this.description
    )
}

fun TaskList.toDto(): TaskListDto {
    return TaskListDto(
        id = this.id.ifEmpty { null },
        title = this.title,
        description = this.description
    )
}