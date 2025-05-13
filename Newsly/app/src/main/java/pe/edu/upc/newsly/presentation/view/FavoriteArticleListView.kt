package pe.edu.upc.newsly.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pe.edu.upc.newsly.presentation.viewmodel.FavoriteArticleListViewModel

@Composable
fun FavoriteArticleListView(viewModel: FavoriteArticleListViewModel) {
    val favorites = viewModel.favorites.collectAsState()
    viewModel.fetchFavorites()

    LazyColumn {
        items(favorites.value) { article ->
            Card(modifier = Modifier.padding(8.dp)) {
                Column {
                    Box {
                        AsyncImage(
                            model = article.poster,
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(384.dp),
                            contentScale = ContentScale.Crop
                        )
                        IconButton(
                            onClick = {
                                viewModel.deleteFavorite(article)
                            },
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(Color.White)
                                .align(Alignment.TopEnd)
                        ) {
                            Icon(
                                Icons.Default.Delete, contentDescription = null
                            )
                        }
                    }
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text(article.title, fontWeight = FontWeight.Bold, maxLines = 1)
                        Text(article.author)
                        Text(article.description)
                    }
                }

            }

        }
    }

}