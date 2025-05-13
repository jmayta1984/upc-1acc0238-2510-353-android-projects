package pe.edu.upc.newsly.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.upc.newsly.data.local.ArticleDao
import pe.edu.upc.newsly.data.model.ArticleEntity
import pe.edu.upc.newsly.data.model.toArticle
import pe.edu.upc.newsly.data.remote.ArticleService
import pe.edu.upc.newsly.domain.model.Article

class ArticleRepository(
    private val articleService: ArticleService,
    private val articleDao: ArticleDao
) {
    suspend fun searchArticles(description: String): List<Article> = withContext(Dispatchers.IO) {
        val response = articleService.searchArticles(description)
        if (response.isSuccessful) {
            response.body()?.let { articlesResponse ->
                return@withContext articlesResponse.map {
                    val article = it.toArticle()
                    article.copy(
                        isFavorite = articleDao.fetchArticlesByTitle(article.title).isNotEmpty()
                    )
                }
            }
        }

        return@withContext emptyList()
    }


    suspend fun insertArticle(article: Article) = withContext(Dispatchers.IO) {
        articleDao.insertArticle(ArticleEntity.fromArticle(article))
    }

    suspend fun deleteArticle(article: Article) = withContext(Dispatchers.IO) {
        articleDao.deleteArticle(ArticleEntity.fromArticle(article))
    }


}