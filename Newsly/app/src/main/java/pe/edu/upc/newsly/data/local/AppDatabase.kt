package pe.edu.upc.newsly.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import pe.edu.upc.newsly.data.model.ArticleEntity

@Database(entities = [ArticleEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
}