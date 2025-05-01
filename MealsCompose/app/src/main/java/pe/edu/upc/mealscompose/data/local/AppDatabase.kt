package pe.edu.upc.mealscompose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import pe.edu.upc.mealscompose.data.model.CategoryEntity

@Database(entities = [CategoryEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
}