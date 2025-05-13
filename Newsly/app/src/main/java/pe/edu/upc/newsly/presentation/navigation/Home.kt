package pe.edu.upc.newsly.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.upc.newsly.domain.model.Article
import pe.edu.upc.newsly.presentation.di.PresentationModule
import pe.edu.upc.newsly.presentation.view.ArticleDetailView
import pe.edu.upc.newsly.presentation.view.ArticleSearchView
import pe.edu.upc.newsly.presentation.view.FavoriteArticleListView

@Composable
fun Home() {
    val navController = rememberNavController()

    val navigationItems = listOf(
        NavigationItem(
            icon = Icons.Default.Search,
            title = "Search",
            route = "search_articles"
        ),
        NavigationItem(
            icon = Icons.Default.Favorite,
            title = "Favorites",
            route = "favorites"
        )
    )

    val selectedIndex = remember {
        mutableStateOf(0)
    }

    val articleSearchViewModel = PresentationModule.getArticleSearchViewModel()
    val favoriteArticleListViewModel = PresentationModule.getFavoriteArticleListViewModel()
    val selectedArticle = remember {
        mutableStateOf<Article?>(null)
    }

    Scaffold(
        bottomBar = {
            NavigationBar {
                navigationItems.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedIndex.value == index,
                        icon = {
                            Icon(item.icon, contentDescription = null)
                        },
                        onClick = {
                            selectedIndex.value = index
                            navController.navigate(item.route)
                        },
                        label = {
                            Text(item.title)
                        }
                    )
                }
            }
        }
    ) { padding ->
        NavHost(
            navController,
            startDestination = "search_articles",
            modifier = Modifier.padding(padding)
        ) {
            composable("search_articles") {
                articleSearchViewModel.searchArticles()
                ArticleSearchView(articleSearchViewModel) { article ->
                    selectedArticle.value = article
                    navController.navigate("news_detail")
                }
            }
            composable("news_detail") {

                selectedArticle.value?.let {
                    ArticleDetailView(it) { isFavorite ->
                        if (isFavorite) {
                            articleSearchViewModel.insertArticle(it)
                        } else {
                            articleSearchViewModel.deleteArticle(it)

                        }
                    }
                }

            }
            composable("favorites") {
                FavoriteArticleListView(favoriteArticleListViewModel)
            }
        }
    }
}

data class NavigationItem(
    val icon: ImageVector,
    val title: String,
    val route: String
)