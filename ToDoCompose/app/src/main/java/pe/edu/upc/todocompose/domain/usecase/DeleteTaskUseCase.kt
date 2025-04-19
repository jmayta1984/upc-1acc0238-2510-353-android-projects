package pe.edu.upc.todocompose.domain.usecase

import pe.edu.upc.todocompose.domain.repository.TaskRepository

class DeleteTaskUseCase(val repository: TaskRepository) {

    operator fun invoke(id: Int){
        repository.deleteTask(id)
    }
}