package pe.edu.upc.mealscompose.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meals")
data class MealEntity(
    @PrimaryKey
    val id: String,
    val name: String
)
