package pe.edu.upc.mealscompose.data.model

import pe.edu.upc.mealscompose.domain.model.Category

object CategoryMapper {


    fun toCategory(categoryResponse: CategoryResponse): Category {
        return Category(
            id = categoryResponse.id ?: "",
            name = categoryResponse.name ?: "",
            description = categoryResponse.description ?: "",
            poster = categoryResponse.poster ?: ""
        )
    }
}