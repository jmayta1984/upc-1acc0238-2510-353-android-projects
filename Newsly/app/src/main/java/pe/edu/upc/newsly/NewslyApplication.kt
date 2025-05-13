package pe.edu.upc.newsly

import android.app.Application

class NewslyApplication : Application() {

    companion object {
        lateinit var instance: NewslyApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}