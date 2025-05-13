package pe.edu.upc.newsly.data.model

import pe.edu.upc.newsly.domain.model.Article

data class ArticleResponse(
    val title: String?,
    val author: String?,
    val description: String?,
    val content: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val source: SourceResponse?
)

fun ArticleResponse.toArticle(): Article {
    return Article(
        author = author ?: "",
        title = title ?: "",
        poster = urlToImage ?: "",
        year = publishedAt?.substring(0, 4) ?: "",
        content = content ?: "",
        source = source?.name ?: "",
        description = description ?: ""
    )
}

data class SourceResponse(
    val id: String?,
    val name: String?
)
