package pe.edu.upc.todocompose.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.upc.todocompose.domain.model.Task

@Preview
@Composable
fun TaskDetail(
    modifier: Modifier = Modifier,
    onSave: (Task) -> Unit = {},
    onDelete: (Int) -> Unit = {},
    onBack: () -> Unit = {}
) {

    val title = remember {
        mutableStateOf("")
    }

    val description = remember {
        mutableStateOf("")
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    val task = Task(
                        id = (0..999).random(),
                        title = title.value,
                        description = description.value
                    )
                    onSave(task)
                    onBack()
                }
            ) {
                Icon(Icons.Default.Save, contentDescription = null)
            }
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                placeholder = {
                    Text("Title")
                },
                value = title.value,
                onValueChange = {
                    title.value = it
                }
            )

            OutlinedTextField(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                placeholder = {
                    Text("Description")
                },
                value = description.value,
                onValueChange = {
                    description.value = it
                }
            )

            OutlinedButton(
                onClick = {
                    onDelete(0)
                }
            ) {
                Text("Delete task")
            }
        }
    }

}