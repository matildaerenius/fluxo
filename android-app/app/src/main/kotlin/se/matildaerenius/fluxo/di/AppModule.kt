package se.matildaerenius.fluxo.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import se.matildaerenius.fluxo.data.remote.ApiService
import se.matildaerenius.fluxo.data.repository.TaskRepositoryImpl
import se.matildaerenius.fluxo.domain.repository.TaskRepository
import se.matildaerenius.fluxo.domain.usecase.task.*
import se.matildaerenius.fluxo.domain.usecase.tasklist.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        val json = Json { ignoreUnknownKeys = true }
        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideTaskRepository(apiService: ApiService): TaskRepository {
        return TaskRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideTaskListUseCases(repository: TaskRepository): TaskListUseCases {
        return TaskListUseCases(
            getTaskLists = GetTaskListsUseCase(repository),
            getTaskList = GetTaskListUseCase(repository),
            createTaskList = CreateTaskListUseCase(repository),
            updateTaskList = UpdateTaskListUseCase(repository),
            deleteTaskList = DeleteTaskListUseCase(repository)
        )
    }

    @Provides
    @Singleton
    fun provideTaskUseCases(repository: TaskRepository): TaskUseCases {
        return TaskUseCases(
            getTasks = GetTasksUseCase(repository),
            getTask = GetTaskUseCase(repository),
            createTask = CreateTaskUseCase(repository),
            updateTask = UpdateTaskUseCase(repository),
            deleteTask = DeleteTaskUseCase(repository)
        )
    }
}