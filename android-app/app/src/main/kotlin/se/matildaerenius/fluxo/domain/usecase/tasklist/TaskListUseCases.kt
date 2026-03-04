package se.matildaerenius.fluxo.domain.usecase.tasklist

data class TaskListUseCases(
    val getTaskLists: GetTaskListsUseCase,
    val getTaskList: GetTaskListUseCase,
    val createTaskList: CreateTaskListUseCase,
    val updateTaskList: UpdateTaskListUseCase,
    val deleteTaskList: DeleteTaskListUseCase
)