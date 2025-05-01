package pe.edu.upc.mealscompose.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.upc.mealscompose.data.di.DataModule
import pe.edu.upc.mealscompose.data.local.CategoryDao
import pe.edu.upc.mealscompose.data.model.CategoryResponse
import pe.edu.upc.mealscompose.data.remote.CategoryService

class CategoryRepository(
    val categoryService: CategoryService = DataModule.getCategoryService(),
    val categoryDao: CategoryDao = DataModule.getCategoryDao()
) {

    suspend fun getCategories(): List<CategoryResponse> = withContext(Dispatchers.IO) {
        val response = categoryService.getCategories()
        if (response.isSuccessful){
            response.body()?.let { it ->
                return@withContext it.categories
            }
        }
        return@withContext emptyList()

    }
}