package pe.edu.upc.newsly.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pe.edu.upc.newsly.domain.model.Article

@Composable
fun ArticleDetailView(
    article: Article,
    toggleFavorite: (Boolean) -> Unit
) {

    val isFavorite = remember {
        mutableStateOf(article.isFavorite)
    }

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
                    isFavorite.value = !isFavorite.value
                    article.isFavorite = isFavorite.value
                    toggleFavorite(isFavorite.value)
                },
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.White)
                    .align(Alignment.TopEnd)
            ) {
                Icon(
                    if (isFavorite.value) {
                        Icons.Default.Favorite
                    } else {
                        Icons.Default.FavoriteBorder
                    }, contentDescription = null
                )
            }
        }
        Column(modifier = Modifier.padding(8.dp)) {
            Text(article.title, fontWeight = FontWeight.Bold, maxLines = 1)
            Text(article.source)
            Text(article.year)
            Text(article.content)
        }
    }
}