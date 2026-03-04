package se.matildaerenius.fluxo.domain.usecase.tasklist

import se.matildaerenius.fluxo.domain.model.TaskList
import se.matildaerenius.fluxo.domain.repository.TaskRepository

class GetTaskListsUseCase(
    private val repository: TaskRepository
) {
    suspend operator fun invoke(): List<TaskList> {
        return repository.getTaskLists()
    }
}