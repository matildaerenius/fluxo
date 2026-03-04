package se.matildaerenius.fluxo.domain.usecase.tasklist

import se.matildaerenius.fluxo.domain.repository.TaskRepository

class DeleteTaskListUseCase(
    private val repository: TaskRepository
) {
    suspend operator fun invoke(id: String) {
        repository.deleteTaskList(id)
    }
}