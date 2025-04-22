package pe.edu.upc.todocompose.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNot
import pe.edu.upc.todocompose.domain.model.Task
import pe.edu.upc.todocompose.domain.repository.TaskRepository

class TaskRepositoryImpl : TaskRepository {

    private var _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks

    override fun getAll(): Flow<List<Task>> {
        return tasks
    }

    override fun addTask(task: Task) {
        _tasks.value += task
    }

    override fun deleteTask(id: Int) {
        _tasks.value = tasks.value.filterNot {
            it.id == id
        }
    }

    override fun updateTask(task: Task) {
        _tasks.value = tasks.value.map {
            if (it.id == task.id) task else it
        }
    }
}