package pe.edu.upc.todocompose.domain.usecase

import kotlinx.coroutines.flow.Flow
import pe.edu.upc.todocompose.domain.model.Task
import pe.edu.upc.todocompose.domain.repository.TaskRepository

class GetAllUseCase(val repository: TaskRepository) {

    operator fun invoke(): Flow<List<Task>>{
        return repository.getAll()
    }
}