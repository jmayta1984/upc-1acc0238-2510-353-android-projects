package pe.edu.upc.mealscompose.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.upc.mealscompose.data.di.DataModule
import pe.edu.upc.mealscompose.data.local.CategoryDao
import pe.edu.upc.mealscompose.data.model.CategoryEntity
import pe.edu.upc.mealscompose.data.model.CategoryMapper
import pe.edu.upc.mealscompose.data.remote.CategoryService
import pe.edu.upc.mealscompose.domain.model.Category

class CategoryRepository(
    val categoryService: CategoryService = DataModule.getCategoryService(),
    val categoryDao: CategoryDao = DataModule.getCategoryDao()
) {

    suspend fun getCategories(): List<Category> = withContext(Dispatchers.IO) {
        val response = categoryService.getCategories()
        if (response.isSuccessful) {
            response.body()?.let { it ->
                return@withContext it.categories.map {
                    val category = CategoryMapper.toCategory(it)
                    category.copy(
                        isFavorite = categoryDao.fetchById(category.id).isNotEmpty()
                    )
                }
            }
        }
        return@withContext emptyList()

    }

    suspend fun insertCategory(category: Category) = withContext(Dispatchers.IO) {
        categoryDao.insertCategory(
            CategoryEntity(
                category.id,
                category.name,
                category.poster
            )
        )
    }

    suspend fun deleteCategory(category: Category) = withContext(Dispatchers.IO) {
        categoryDao.deleteCategory(
            CategoryEntity(
                category.id,
                category.name,
                category.poster
            )
        )
    }

}