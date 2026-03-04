package se.matildaerenius.fluxo.presentation.navigation

sealed class Screen(val route: String) {
    data object TaskList : Screen("task_list")
    data object Tasks : Screen("tasks/{taskListId}") {
        fun createRoute(taskListId: String) = "tasks/$taskListId"
    }
}