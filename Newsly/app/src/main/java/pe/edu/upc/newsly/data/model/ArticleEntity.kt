package pe.edu.upc.newsly.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.coroutines.delay
import pe.edu.upc.newsly.domain.model.Article
import pe.edu.upc.newsly.domain.model.FavoriteArticle

@Entity(tableName = "articles")
data class ArticleEntity(
    @PrimaryKey
    val title: String,
    val author: String,
    val poster: String,
    val description: String
) {

    fun toFavoriteArticle(): FavoriteArticle {
        return FavoriteArticle(
            title = title,
            author = author,
            poster = poster,
            description = description
        )
    }

    companion object {
        fun fromArticle(article: Article): ArticleEntity {
            article.apply {
                return ArticleEntity(
                    title = title,
                    author = author,
                    poster = poster,
                    description = description
                )
            }

        }

        fun fromFavoriteArticle(favoriteArticle: FavoriteArticle): ArticleEntity {
            favoriteArticle.apply {
                return ArticleEntity(
                    title = title,
                    author = author,
                    poster = poster,
                    description = description
                )
            }

        }
    }
}