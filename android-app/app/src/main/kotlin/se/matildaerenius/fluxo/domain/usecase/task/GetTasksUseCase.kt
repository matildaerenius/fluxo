package se.matildaerenius.fluxo.domain.usecase.task

import se.matildaerenius.fluxo.domain.model.Task
import se.matildaerenius.fluxo.domain.repository.TaskRepository

class GetTasksUseCase(
    private val repository: TaskRepository
) {
    suspend operator fun invoke(taskListId: String): List<Task> {
        return repository.getTasks(taskListId)
    }
}