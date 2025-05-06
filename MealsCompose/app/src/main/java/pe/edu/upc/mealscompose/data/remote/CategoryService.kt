package pe.edu.upc.mealscompose.data.remote

import pe.edu.upc.mealscompose.data.model.CategoriesResponse
import retrofit2.Response
import retrofit2.http.GET

interface CategoryService {

    @GET("categories.php")
    suspend fun getCategories(): Response<CategoriesResponse>


}