package pe.edu.upc.mealscompose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import pe.edu.upc.mealscompose.data.model.CategoryEntity
import pe.edu.upc.mealscompose.data.model.MealEntity

@Database(
    entities = [CategoryEntity::class, MealEntity::class],
    version = 2, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun mealDao(): MealDao
}