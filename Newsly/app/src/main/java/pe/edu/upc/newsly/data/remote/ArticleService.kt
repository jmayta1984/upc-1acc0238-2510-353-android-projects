package pe.edu.upc.newsly.data.remote

import pe.edu.upc.newsly.data.model.ArticleResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleService {

    @GET("articles.php")
    suspend fun searchArticles(@Query("description") description: String): Response<List<ArticleResponse>>
}