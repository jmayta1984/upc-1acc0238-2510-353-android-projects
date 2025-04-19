package pe.edu.upc.todocompose.domain.usecase

import pe.edu.upc.todocompose.domain.model.Task
import pe.edu.upc.todocompose.domain.repository.TaskRepository

class AddTaskUseCase(val repository: TaskRepository) {

    operator fun invoke(task: Task){
        repository.addTask(task)
    }
}