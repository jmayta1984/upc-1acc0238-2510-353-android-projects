package pe.edu.upc.todocompose.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.upc.todocompose.data.repository.TaskRepositoryImpl
import pe.edu.upc.todocompose.domain.model.Task
import pe.edu.upc.todocompose.domain.usecase.AddTaskUseCase
import pe.edu.upc.todocompose.domain.usecase.DeleteTaskUseCase
import pe.edu.upc.todocompose.domain.usecase.GetAllUseCase

@Preview
@Composable
fun Home() {
    val navController = rememberNavController()

    val repository = TaskRepositoryImpl()
    val getAllUseCase = GetAllUseCase(repository)
    val addTaskUseCase = AddTaskUseCase(repository)
    val deleteTaskUseCase = DeleteTaskUseCase(repository)

    val tasks = getAllUseCase().collectAsState(emptyList())

    NavHost(
        navController = navController,
        startDestination = Routes.TaskList.route
    ) {
        composable(Routes.TaskList.route) {
            TaskList(tasks = tasks.value) {
                navController.navigate(Routes.TaskDetail.route)
            }
        }
        composable(Routes.TaskDetail.route) {
            TaskDetail(
                onSave = { task ->
                    addTaskUseCase(task)
                },
                onDelete = { id ->
                    deleteTaskUseCase(id)
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}


sealed class Routes(val route: String) {
    data object TaskList : Routes(route = "TaskList")
    data object TaskDetail : Routes(route = "TaskDetail")
}