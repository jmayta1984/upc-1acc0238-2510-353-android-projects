package pe.edu.upc.mealscompose.data.di

import androidx.room.Room
import pe.edu.upc.mealscompose.MealsApplication
import pe.edu.upc.mealscompose.data.local.AppDatabase
import pe.edu.upc.mealscompose.data.local.CategoryDao
import pe.edu.upc.mealscompose.data.local.MealDao
import pe.edu.upc.mealscompose.data.remote.ApiConstants
import pe.edu.upc.mealscompose.data.remote.CategoryService
import pe.edu.upc.mealscompose.data.remote.MealService
import pe.edu.upc.mealscompose.data.repository.CategoryRepository
import pe.edu.upc.mealscompose.data.repository.MealRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataModule {

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getCategoryService(): CategoryService {
        return getRetrofit().create(CategoryService::class.java)

    }

    fun getCategoryRepository(): CategoryRepository {
        return CategoryRepository(getCategoryService())
    }

    fun getAppDatabase(): AppDatabase {
        return Room.databaseBuilder(
                MealsApplication.instance.applicationContext,
                AppDatabase::class.java,
                "meals-db"
            ).fallbackToDestructiveMigration(false)

            .build()
    }

    fun getMealDao(): MealDao {
        return getAppDatabase().mealDao()
    }


    fun getCategoryDao(): CategoryDao {
        return getAppDatabase().categoryDao()
    }

    fun getMealService(): MealService {
        return getRetrofit().create(MealService::class.java)

    }

    fun getMealRepository(): MealRepository {
        return MealRepository(getMealService(), getMealDao())
    }
}