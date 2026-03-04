package se.matildaerenius.fluxo.domain.usecase.tasklist

import se.matildaerenius.fluxo.domain.model.TaskList
import se.matildaerenius.fluxo.domain.repository.TaskRepository

class CreateTaskListUseCase(
    private val repository: TaskRepository
) {
    suspend operator fun invoke(taskList: TaskList): TaskList {
        return repository.createTaskList(taskList)
    }
}