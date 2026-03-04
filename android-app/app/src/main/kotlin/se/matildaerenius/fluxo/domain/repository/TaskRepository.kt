package se.matildaerenius.fluxo.domain.repository

import se.matildaerenius.fluxo.domain.model.TaskList
import se.matildaerenius.fluxo.domain.model.Task

interface TaskRepository {
    suspend fun getTaskLists(): List<TaskList>
    suspend fun createTaskList(taskList: TaskList): TaskList
    suspend fun deleteTaskList(id: String)
    suspend fun getTasks(taskListId: String): List<Task>
    suspend fun createTask(taskListId: String, task: Task): Task
    suspend fun updateTask(taskListId: String, taskId: String, task: Task): Task
}