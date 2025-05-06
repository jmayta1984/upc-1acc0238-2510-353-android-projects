package pe.edu.upc.mealscompose.domain.model

data class Category(
    val id: String,
    val name: String,
    val description: String,
    val poster: String,
    var isFavorite: Boolean = false
)
