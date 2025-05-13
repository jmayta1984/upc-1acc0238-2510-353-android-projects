package pe.edu.upc.newsly.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pe.edu.upc.newsly.domain.model.Article
import pe.edu.upc.newsly.presentation.viewmodel.ArticleSearchViewModel

@Composable
fun ArticleSearchView(
    viewModel: ArticleSearchViewModel,
    onTap: (Article) -> Unit
) {

    val description = viewModel.description.collectAsState()

    val articles = viewModel.articles.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        OutlinedTextField(
            description.value,
            onValueChange = { viewModel.updateDescription(it) },
            modifier = Modifier
                .fillMaxWidth(),
            trailingIcon = {
                IconButton(
                    onClick = {
                        viewModel.searchArticles()
                    }
                ) {
                    Icon(Icons.Default.Search, contentDescription = null)
                }
            }
        )
        LazyColumn {
            items(articles.value) { article ->
                ArticleListItemView(article, onTap)
            }
        }
    }
}

@Composable
fun ArticleListItemView(article: Article, onTap: (Article) -> Unit) {
    Card(
        modifier = Modifier.padding(8.dp),
        onClick = {
            onTap(article)
        }
    ) {
        Column {
            AsyncImage(
                model = article.poster,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(256.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(8.dp)) {
                Text(article.title, fontWeight = FontWeight.Bold, maxLines = 1)
                Text(article.author)
                Text(article.year)
            }
        }
    }
}
