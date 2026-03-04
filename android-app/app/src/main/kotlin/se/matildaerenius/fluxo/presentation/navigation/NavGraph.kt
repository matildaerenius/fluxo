package se.matildaerenius.fluxo.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import se.matildaerenius.fluxo.presentation.feature.task.TaskScreen
import se.matildaerenius.fluxo.presentation.feature.task.TaskViewModel
import se.matildaerenius.fluxo.presentation.feature.tasklist.TaskListScreen
import se.matildaerenius.fluxo.presentation.feature.tasklist.TaskListViewModel

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.TaskList.route
    ) {
        composable(route = Screen.TaskList.route) {
            val viewModel: TaskListViewModel = hiltViewModel()
            TaskListScreen(
                viewModel = viewModel,
                onListClick = { listId ->
                    navController.navigate(Screen.Tasks.createRoute(listId))
                }
            )
        }

        composable(
            route = Screen.Tasks.route,
            arguments = listOf(
                navArgument("taskListId") { type = NavType.StringType }
            )
        ) {
            val viewModel: TaskViewModel = hiltViewModel()
            TaskScreen(
                viewModel = viewModel,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}