package se.matildaerenius.fluxo.domain.usecase.task

import se.matildaerenius.fluxo.domain.repository.TaskRepository

class DeleteTaskUseCase(private val repository: TaskRepository) {
    suspend operator fun invoke(taskListId: String, taskId: String) {
        repository.deleteTask(taskListId, taskId)
    }
}