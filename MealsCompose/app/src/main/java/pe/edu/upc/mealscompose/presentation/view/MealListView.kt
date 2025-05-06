package pe.edu.upc.mealscompose.presentation.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import pe.edu.upc.mealscompose.presentation.viewmodel.MealListViewModel

@Composable
fun MealListView(
    viewModel: MealListViewModel = MealListViewModel()
){
    val meals = viewModel.meals.collectAsState()

    viewModel.getMealsByCategory("vegan")

    LazyColumn {
        items(meals.value) { meal ->
            Text(meal.name)
        }
    }
}