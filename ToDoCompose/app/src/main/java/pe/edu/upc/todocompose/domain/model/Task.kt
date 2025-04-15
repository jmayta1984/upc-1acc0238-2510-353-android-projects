package pe.edu.upc.todocompose.domain.model

data class Task(
    val title: String,
    val description: String,
    var isCompleted: Boolean = false
)
