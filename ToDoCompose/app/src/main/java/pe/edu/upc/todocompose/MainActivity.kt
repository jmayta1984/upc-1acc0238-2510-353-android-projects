package pe.edu.upc.todocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import pe.edu.upc.todocompose.presentation.ui.Home
import pe.edu.upc.todocompose.presentation.ui.theme.ToDoComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToDoComposeTheme {
                Home()
            }
        }
    }
}
