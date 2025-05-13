package pe.edu.upc.newsly.domain.model

data class Article(
    val year: String,
    val title: String,
    val author: String,
    val poster: String,
    val content: String,
    val source: String,
    val description: String,
    var isFavorite: Boolean = false
)
