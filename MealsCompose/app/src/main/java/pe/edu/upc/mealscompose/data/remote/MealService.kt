package pe.edu.upc.mealscompose.data.remote

import pe.edu.upc.mealscompose.data.model.MealsResponse
import retrofit2.http.Query

import retrofit2.Response
import retrofit2.http.GET

interface MealService {

    @GET("filter.php")
    suspend fun getMealsByCategory(@Query("c") category: String): Response<MealsResponse>
}