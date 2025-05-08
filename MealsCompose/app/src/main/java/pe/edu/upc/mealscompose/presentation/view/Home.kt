package pe.edu.upc.mealscompose.presentation.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.upc.mealscompose.domain.model.Category

@Composable
fun Home() {
    val navController = rememberNavController()

    val selectedCategory = remember {
        mutableStateOf<Category?>(null)
    }

    NavHost(navController, startDestination = "categories") {

        composable("categories") {
            CategoryListView { category ->
                selectedCategory.value = category
                navController.navigate("meals")
            }
        }

        composable("meals") {
            selectedCategory.value?.let { category ->
                MealListView(category = category.name)
            }

        }
    }


}