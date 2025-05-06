package pe.edu.upc.mealscompose.data.model

import pe.edu.upc.mealscompose.domain.model.Meal

object MealMapper {

    fun toMeal(mealResponse: MealResponse): Meal {
        return Meal(
            id = mealResponse.id ?: "",
            name = mealResponse.name ?: "",
            poster = mealResponse.poster ?: ""
        )
    }
}