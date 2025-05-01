package pe.edu.upc.mealscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import pe.edu.upc.mealscompose.presentation.view.CategoryList
import pe.edu.upc.mealscompose.ui.theme.MealsComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            MealsComposeTheme {
                CategoryList()
            }
        }
    }
}
