package se.matildaerenius.fluxo.domain.usecase.task

import se.matildaerenius.fluxo.domain.model.Task
import se.matildaerenius.fluxo.domain.repository.TaskRepository

class UpdateTaskUseCase(
    private val repository: TaskRepository
) {
    suspend operator fun invoke(taskListId: String, taskId: String, task: Task): Task {
        return repository.updateTask(taskListId, taskId, task)
    }
}