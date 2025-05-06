package pe.edu.upc.mealscompose.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pe.edu.upc.mealscompose.domain.model.Category
import pe.edu.upc.mealscompose.presentation.viewmodel.CategoryListViewModel

@Composable
fun CategoryList(viewModel: CategoryListViewModel = CategoryListViewModel()) {
    viewModel.getCategories()

    val categories = viewModel.categories.collectAsState()

    Scaffold { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(categories.value) { category ->
                CategoryListItemView(category) { isFavorite ->
                    if (isFavorite) {
                        viewModel.insertCategory(category)
                    } else {
                        viewModel.deleteCategory(category)
                    }
                }
            }
        }
    }
}

@Composable
fun CategoryListItemView(
    category: Category,
    toggleFavorite: (Boolean) -> Unit
) {


    val isFavorite = remember {
        mutableStateOf(category.isFavorite)
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = category.poster,
                contentDescription = null,
                modifier = Modifier.size(96.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .weight(1f)
            ) {
                Text(category.name, fontWeight = FontWeight.Bold)
                Text(category.description, maxLines = 1)

            }
            IconButton(
                onClick = {
                    isFavorite.value = !isFavorite.value
                    category.isFavorite = isFavorite.value
                    toggleFavorite(isFavorite.value)
                }
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
    }
}