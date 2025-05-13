package pe.edu.upc.newsly.data.di

import androidx.room.Room
import pe.edu.upc.newsly.NewslyApplication
import pe.edu.upc.newsly.data.local.AppDatabase
import pe.edu.upc.newsly.data.local.ArticleDao
import pe.edu.upc.newsly.data.remote.ApiConstants
import pe.edu.upc.newsly.data.remote.ArticleService
import pe.edu.upc.newsly.data.repository.ArticleRepository
import pe.edu.upc.newsly.data.repository.FavoriteArticleRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataModule {

    fun getArticleRepository(): ArticleRepository {
        return ArticleRepository(getArticleService(), getArticleDao())
    }

    fun getArticleService(): ArticleService {
        return getRetrofit().create(ArticleService::class.java)
    }

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getArticleDao(): ArticleDao {
        return getAppDatabase().articleDao()
    }

    fun getAppDatabase(): AppDatabase {
        return Room.databaseBuilder(
            NewslyApplication.instance.applicationContext,
            AppDatabase::class.java, "newsly-db"
        ).build()
    }

    fun getFavoriteArticleRepository(): FavoriteArticleRepository {
        return FavoriteArticleRepository(getArticleDao())
    }
}