package pe.edu.upc.newsly.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.upc.newsly.data.local.ArticleDao
import pe.edu.upc.newsly.data.model.ArticleEntity
import pe.edu.upc.newsly.domain.model.FavoriteArticle

class FavoriteArticleRepository(private val articleDao: ArticleDao) {

    suspend fun fetchFavoriteArticles(): List<FavoriteArticle> = withContext(Dispatchers.IO) {
        return@withContext articleDao.fetchArticles().map {
            it.toFavoriteArticle()
        }
    }

    suspend fun deleteFavoriteArticle(favoriteArticle: FavoriteArticle) {
        articleDao.deleteArticle(ArticleEntity.fromFavoriteArticle(favoriteArticle))
    }
}