package pe.edu.upc.jokescompose.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.upc.jokescompose.data.remote.ApiClient
import pe.edu.upc.jokescompose.data.remote.JokeService
import pe.edu.upc.jokescompose.data.repository.JokeRepositoryImpl


@Preview
@Composable
fun JokeView() {
    val joke = remember {
        mutableStateOf("")
    }

    val jokeService = ApiClient.getRetrofit().create(JokeService::class.java)
    val repository = JokeRepositoryImpl(jokeService)

    Scaffold { padding ->
        Column (
            modifier = Modifier.fillMaxSize().padding(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(joke.value)
            IconButton(
                onClick = {
                    repository.getRandomJoke {
                        joke.value = it.content
                    }
                }
            ) {
                Icon(Icons.Default.Refresh, contentDescription = null)
            }
        }

    }

}
