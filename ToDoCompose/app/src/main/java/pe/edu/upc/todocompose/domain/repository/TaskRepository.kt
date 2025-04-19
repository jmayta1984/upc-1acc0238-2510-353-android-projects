package pe.edu.upc.todocompose.domain.repository

import kotlinx.coroutines.flow.Flow
import pe.edu.upc.todocompose.domain.model.Task

interface TaskRepository {
    fun getAll(): Flow<List<Task>>
    fun addTask(task: Task)
    fun deleteTask(id: Int)
    fun updateTask()
}