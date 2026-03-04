package se.matildaerenius.fluxo.domain.repository

import se.matildaerenius.fluxo.domain.model.Task
import se.matildaerenius.fluxo.domain.model.TaskList

interface TaskRepository {
    suspend fun getTaskLists(): List<TaskList>
    suspend fun getTaskList(id: String): TaskList
    suspend fun createTaskList(taskList: TaskList): TaskList
    suspend fun updateTaskList(id: String, taskList: TaskList): TaskList
    suspend fun deleteTaskList(id: String)

    suspend fun getTasks(taskListId: String): List<Task>
    suspend fun getTask(taskListId: String, taskId: String): Task
    suspend fun createTask(taskListId: String, task: Task): Task
    suspend fun updateTask(taskListId: String, taskId: String, task: Task): Task
    suspend fun deleteTask(taskListId: String, taskId: String)
}