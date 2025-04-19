package pe.edu.upc.todocompose.domain.model

data class Task(
    val  id: Int,
    val title: String,
    val description: String,
    var isCompleted: Boolean = false
)
