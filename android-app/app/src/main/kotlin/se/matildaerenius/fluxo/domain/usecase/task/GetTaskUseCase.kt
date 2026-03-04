package se.matildaerenius.fluxo.domain.usecase.task

import se.matildaerenius.fluxo.domain.model.Task
import se.matildaerenius.fluxo.domain.repository.TaskRepository

class GetTaskUseCase(private val repository: TaskRepository) {
    suspend operator fun invoke(taskListId: String, taskId: String): Task {
        return repository.getTask(taskListId, taskId)
    }
}