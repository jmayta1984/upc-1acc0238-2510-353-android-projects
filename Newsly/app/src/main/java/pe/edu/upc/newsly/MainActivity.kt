package pe.edu.upc.newsly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import pe.edu.upc.newsly.presentation.navigation.Home
import pe.edu.upc.newsly.ui.theme.NewslyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewslyTheme {
                Home()
            }
        }
    }
}
