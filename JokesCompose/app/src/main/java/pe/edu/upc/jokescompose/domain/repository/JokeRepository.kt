package pe.edu.upc.jokescompose.domain.repository

import pe.edu.upc.jokescompose.data.model.Joke
import pe.edu.upc.jokescompose.data.remote.JokeService

interface JokeRepository {

    fun getRandomJoke(callback: (Joke) -> Unit)
}