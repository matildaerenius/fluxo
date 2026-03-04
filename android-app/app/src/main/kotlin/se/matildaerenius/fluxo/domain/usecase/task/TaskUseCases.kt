package se.matildaerenius.fluxo.domain.usecase.task

data class TaskUseCases(
    val getTasks: GetTasksUseCase,
    val getTask: GetTaskUseCase,
    val createTask: CreateTaskUseCase,
    val updateTask: UpdateTaskUseCase,
    val deleteTask: DeleteTaskUseCase
)