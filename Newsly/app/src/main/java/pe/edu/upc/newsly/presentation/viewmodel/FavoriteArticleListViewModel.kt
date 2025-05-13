package pe.edu.upc.newsly.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.upc.newsly.data.repository.FavoriteArticleRepository
import pe.edu.upc.newsly.domain.model.FavoriteArticle

class FavoriteArticleListViewModel(private val favoriteArticleRepository: FavoriteArticleRepository) :
    ViewModel() {

    private val _favorites = MutableStateFlow<List<FavoriteArticle>>(emptyList())
    val favorites: StateFlow<List<FavoriteArticle>> = _favorites


    fun fetchFavorites() {
        viewModelScope.launch {
            _favorites.value = favoriteArticleRepository.fetchFavoriteArticles()
        }
    }

    fun deleteFavorite(favoriteArticle: FavoriteArticle) {
        viewModelScope.launch {
            favoriteArticleRepository.deleteFavoriteArticle(favoriteArticle)
            fetchFavorites()
        }
    }
}