package pe.edu.upc.todocompose.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.upc.todocompose.domain.model.Task

@Preview
@Composable
fun Home() {
    val navController = rememberNavController()
    val tasks = remember {
        mutableStateOf(emptyList<Task>())
    }

    NavHost(
        navController = navController,
        startDestination = Routes.TaskList.route
    ) {
        composable(Routes.TaskList.route) {
            TaskList(tasks = tasks.value) {
                navController.navigate("TaskDetail")
            }
        }
        composable(Routes.TaskDetail.route) {
            TaskDetail { task ->
                tasks.value += task
                navController.popBackStack()
            }
        }
    }
}


sealed class Routes(val route: String) {
    data object TaskList : Routes(route = "TaskList")
    data object TaskDetail : Routes(route = "TaskDetail")


}