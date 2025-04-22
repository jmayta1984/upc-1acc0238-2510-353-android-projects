package pe.edu.upc.countercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import pe.edu.upc.countercompose.ui.theme.CounterComposeTheme

class MainActivity : ComponentActivity() {
    val viewModel by viewModels<CounterViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterComposeTheme {
                CounterView(viewModel = viewModel)

            }
        }
    }
}
