package pe.edu.upc.jokescompose.data.repository

import android.util.Log
import pe.edu.upc.jokescompose.data.model.Joke
import pe.edu.upc.jokescompose.data.remote.JokeService
import pe.edu.upc.jokescompose.domain.repository.JokeRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JokeRepositoryImpl(val jokeService: JokeService): JokeRepository {
    override fun getRandomJoke(callback: (Joke) -> Unit) {
        jokeService.getRandomJoke().enqueue(object : Callback<Joke> {

            override fun onResponse(
                call: Call<Joke?>,
                response: Response<Joke?>
            ) {
                if (response.isSuccessful){
                    response.body()?.let {
                        callback(it)
                    }
                }
            }

            override fun onFailure(
                call: Call<Joke?>,
                t: Throwable
            ) {
                t.message?.let {
                    Log.d("JokeRepositoryImpl", it)
                }
            }

        })
    }
}