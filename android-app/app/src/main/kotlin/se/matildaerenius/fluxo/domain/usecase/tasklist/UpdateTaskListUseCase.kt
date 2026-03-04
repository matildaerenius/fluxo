package se.matildaerenius.fluxo.domain.usecase.tasklist

import se.matildaerenius.fluxo.domain.model.TaskList
import se.matildaerenius.fluxo.domain.repository.TaskRepository

class UpdateTaskListUseCase(private val repository: TaskRepository) {
    suspend operator fun invoke(id: String, taskList: TaskList): TaskList {
        return repository.updateTaskList(id, taskList)
    }
}