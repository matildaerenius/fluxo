package se.matildaerenius.fluxo.data.repository

import se.matildaerenius.fluxo.data.remote.ApiService
import se.matildaerenius.fluxo.data.remote.mapper.toDomain
import se.matildaerenius.fluxo.data.remote.mapper.toDto
import se.matildaerenius.fluxo.domain.model.TaskList
import se.matildaerenius.fluxo.domain.model.Task
import se.matildaerenius.fluxo.domain.repository.TaskRepository

class TaskRepositoryImpl(
    private val apiService: ApiService
) : TaskRepository {

    override suspend fun getTaskLists(): List<TaskList> {
        return apiService.getTaskLists().map { it.toDomain() }
    }

    override suspend fun createTaskList(taskList: TaskList): TaskList {
        val resultDto = apiService.createTaskList(taskList.toDto())
        return resultDto.toDomain()
    }

    override suspend fun deleteTaskList(id: String) {
        apiService.deleteTaskList(id)
    }

    override suspend fun getTasks(taskListId: String): List<Task> {
        return apiService.getTasks(taskListId).map { it.toDomain() }
    }

    override suspend fun createTask(taskListId: String, task: Task): Task {
        val resultDto = apiService.createTask(taskListId, task.toDto())
        return resultDto.toDomain()
    }

    override suspend fun updateTask(taskListId: String, taskId: String, task: Task): Task {
        val resultDto = apiService.updateTask(taskListId, taskId, task.toDto())
        return resultDto.toDomain()
    }
}