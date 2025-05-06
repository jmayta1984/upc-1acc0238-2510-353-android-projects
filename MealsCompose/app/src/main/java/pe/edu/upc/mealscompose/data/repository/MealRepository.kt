package pe.edu.upc.mealscompose.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.upc.mealscompose.data.model.MealMapper
import pe.edu.upc.mealscompose.data.remote.MealService
import pe.edu.upc.mealscompose.domain.model.Meal

class MealRepository(val mealService: MealService) {

    suspend fun getMealsByCategory(category: String): List<Meal> = withContext(Dispatchers.IO) {

        val response = mealService.getMealsByCategory(category)

        if (response.isSuccessful) {
            response.body()?.let { it ->
                return@withContext it.meals.map { mealResponse ->
                    MealMapper.toMeal(mealResponse)
                }
            }
        }
        return@withContext emptyList()
    }
}