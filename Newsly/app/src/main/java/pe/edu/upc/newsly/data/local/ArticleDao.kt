package pe.edu.upc.newsly.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import pe.edu.upc.newsly.data.model.ArticleEntity

@Dao
interface ArticleDao {

    @Insert
    suspend fun insertArticle(articleEntity: ArticleEntity)

    @Delete
    suspend fun deleteArticle(articleEntity: ArticleEntity)

    @Query("select * from articles")
    suspend fun fetchArticles(): List<ArticleEntity>

    @Query("select * from articles where title=:title")
    suspend fun fetchArticlesByTitle(title: String): List<ArticleEntity>
}