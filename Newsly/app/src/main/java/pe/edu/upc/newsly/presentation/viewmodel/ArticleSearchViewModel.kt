package pe.edu.upc.newsly.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.upc.newsly.data.repository.ArticleRepository
import pe.edu.upc.newsly.domain.model.Article

class ArticleSearchViewModel(private val articleRepository: ArticleRepository) : ViewModel() {
    private val _articles = MutableStateFlow<List<Article>>(emptyList())
    val articles: StateFlow<List<Article>> = _articles

    private val _description = MutableStateFlow<String>("")
    val description: StateFlow<String> = _description

    fun updateDescription(description: String) {
        _description.value = description
    }

    fun searchArticles() {
        viewModelScope.launch {
            _articles.value = articleRepository.searchArticles(_description.value)
        }
    }

    fun insertArticle(article: Article) {
        viewModelScope.launch {
            articleRepository.insertArticle(article)
        }
    }

    fun deleteArticle(article: Article) {
        viewModelScope.launch {
            articleRepository.deleteArticle(article)
        }
    }
}