package se.matildaerenius.fluxo.data.remote

import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import se.matildaerenius.fluxo.data.remote.dto.TaskDto
import se.matildaerenius.fluxo.data.remote.dto.TaskListDto

interface ApiService {
    @GET("task-lists")
    suspend fun getTaskLists(): List<TaskListDto>

    @POST("task-lists")
    suspend fun createTaskList(@Body taskList: TaskListDto): TaskListDto

    @DELETE("task-lists/{id}")
    suspend fun deleteTaskList(@Path("id") id: String)

    @GET("task-lists/{taskListId}/tasks")
    suspend fun getTasks(@Path("taskListId") taskListId: String): List<TaskDto>

    @POST("task-lists/{taskListId}/tasks")
    suspend fun createTask(@Path("taskListId") taskListId: String, @Body task: TaskDto): TaskDto

    @PUT("task-lists/{taskListId}/tasks/{taskId}")
    suspend fun updateTask(
        @Path("taskListId") taskListId: String,
        @Path("taskId") taskId: String,
        @Body task: TaskDto
    ): TaskDto

    @GET("task-lists/{id}")
    suspend fun getTaskList(@Path("id") id: String): TaskListDto

    @PUT("task-lists/{id}")
    suspend fun updateTaskList(
        @Path("id") id: String,
        @Body taskList: TaskListDto
    ): TaskListDto

    @GET("task-lists/{taskListId}/tasks/{taskId}")
    suspend fun getTask(
        @Path("taskListId") taskListId: String,
        @Path("taskId") taskId: String
    ): TaskDto

    @DELETE("task-lists/{taskListId}/tasks/{taskId}")
    suspend fun deleteTask(
        @Path("taskListId") taskListId: String,
        @Path("taskId") taskId: String
    )

}