package pe.edu.upc.todocompose.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.upc.todocompose.domain.model.Task

@Preview
@Composable
fun TaskList(
    modifier: Modifier = Modifier,
    tasks: List<Task> = listOf(),
    onAdd: () -> Unit = {}
) {


    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onAdd()
                }
            ) {
                Icon(Icons.Default.Add, contentDescription = null)
            }
        }
    ) { padding ->
        LazyColumn(modifier = modifier.padding(padding))
        {
            items(tasks) { task ->
                TaskListItem(task = task)
            }
        }
    }
}

@Composable
fun TaskListItem(task: Task) {

    val isCompleted = remember {
        mutableStateOf(task.isCompleted)
    }

    Card(modifier = Modifier.padding(8.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Checkbox(checked = isCompleted.value, onCheckedChange = {
                isCompleted.value = it
            })
            Column {
                Text(task.title, fontWeight = FontWeight.Bold)
                Text(task.description)
            }


        }
    }


}