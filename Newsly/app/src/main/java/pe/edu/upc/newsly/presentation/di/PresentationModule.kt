package pe.edu.upc.newsly.presentation.di

import pe.edu.upc.newsly.data.di.DataModule
import pe.edu.upc.newsly.presentation.viewmodel.ArticleSearchViewModel
import pe.edu.upc.newsly.presentation.viewmodel.FavoriteArticleListViewModel

object PresentationModule {

    fun getArticleSearchViewModel(): ArticleSearchViewModel {
        return ArticleSearchViewModel(DataModule.getArticleRepository())
    }

    fun getFavoriteArticleListViewModel(): FavoriteArticleListViewModel {
        return FavoriteArticleListViewModel(DataModule.getFavoriteArticleRepository())
    }
}