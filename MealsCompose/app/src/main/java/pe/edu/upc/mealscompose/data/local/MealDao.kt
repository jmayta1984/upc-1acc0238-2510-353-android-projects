package pe.edu.upc.mealscompose.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import pe.edu.upc.mealscompose.data.model.CategoryEntity
import pe.edu.upc.mealscompose.data.model.MealEntity

@Dao
interface MealDao {
    @Query("select * from meals")
    suspend fun fetchMeals(): List<MealEntity>

    @Insert
    suspend fun insertMeal(meal: MealEntity)

    @Delete
    suspend fun deleteMeal(meal: MealEntity)

    @Query("select * from meals where id =:id")
    suspend fun fetchById(id: String): List<MealEntity>

}