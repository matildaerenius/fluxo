package se.matildaerenius.fluxo.domain.usecase.task

import se.matildaerenius.fluxo.domain.model.Task
import se.matildaerenius.fluxo.domain.repository.TaskRepository

class CreateTaskUseCase(
    private val repository: TaskRepository
) {
    suspend operator fun invoke(taskListId: String, task: Task): Task {
        return repository.createTask(taskListId, task)
    }
}