package se.matildaerenius.fluxo.domain.usecase.tasklist

import se.matildaerenius.fluxo.domain.model.TaskList
import se.matildaerenius.fluxo.domain.repository.TaskRepository

class GetTaskListUseCase(private val repository: TaskRepository) {
    suspend operator fun invoke(id: String): TaskList {
        return repository.getTaskList(id)
    }
}