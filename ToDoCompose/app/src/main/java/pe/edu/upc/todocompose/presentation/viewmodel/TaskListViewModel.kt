package pe.edu.upc.todocompose.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import pe.edu.upc.todocompose.domain.model.Task
import pe.edu.upc.todocompose.domain.usecase.AddTaskUseCase
import pe.edu.upc.todocompose.domain.usecase.DeleteTaskUseCase
import pe.edu.upc.todocompose.domain.usecase.GetAllUseCase
import pe.edu.upc.todocompose.domain.usecase.UpdateTaskUseCase

class TaskListViewModel(
    private val getAllUseCase: GetAllUseCase,
    private val addTaskUseCase: AddTaskUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase

) : ViewModel(

) {
    private var _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks

    fun getAll(): Flow<List<Task>>{
        return getAllUseCase()
    }

    fun addTask(task: Task){
        addTaskUseCase(task)
    }

    fun deleteTask(id: Int){
        deleteTaskUseCase(id)
    }

    fun updateTask(task: Task){
        updateTaskUseCase(task)
    }

}