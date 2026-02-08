package com.example.viikkotehtava1.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.viikkotehtava1.domain.TaskFilter
import com.example.viikkotehtava1.domain.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: TaskViewModel,
    onNavigateCalendar: () -> Unit = {}
) {
    val tasks by viewModel.tasks.collectAsState()
    val selectedTask by viewModel.selectedTask.collectAsState()

    var newTitle by remember { mutableStateOf("") }
    var newDescription by remember { mutableStateOf("") }
    var newDueDate by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {

        TopAppBar(
            title = { Text("Tehtävät") },
            actions = {
                IconButton(onClick = onNavigateCalendar) {
                    Icon(
                        imageVector = Icons.Default.CalendarMonth,
                        contentDescription = "Kalenteri"
                    )
                }
            }
        )

        TaskFilterRow(
            onAll = { viewModel.setFilter(TaskFilter.ALL) },
            onDone = { viewModel.setFilter(TaskFilter.DONE) },
            onTodo = { viewModel.setFilter(TaskFilter.TODO) },
            onOrderByDueDate = { viewModel.toggleOrderByDueDate() }
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = newTitle,
            onValueChange = { newTitle = it },
            label = { Text("Otsikko") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )

        OutlinedTextField(
            value = newDescription,
            onValueChange = { newDescription = it },
            label = { Text("Kuvaus") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        OutlinedTextField(
            value = newDueDate,
            onValueChange = { newDueDate = it },
            label = { Text("Eräpäivä (YYYY-MM-DD)") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )

        Button(
            onClick = {
                if (newTitle.isNotBlank()) {
                    viewModel.addTask(newTitle, newDescription, newDueDate)
                    newTitle = ""
                    newDescription = ""
                    newDueDate = ""
                }
            },
            modifier = Modifier
                .align(Alignment.End)
                .padding(8.dp)
        ) {
            Text("Lisää tehtävä")
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            items(tasks) { task ->
                Card(
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .fillMaxWidth()
                        .clickable { viewModel.selectTask(task) }
                ) {
                    Row(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(task.title, style = MaterialTheme.typography.titleMedium)
                            Text(task.description)
                        }
                        Checkbox(
                            checked = task.done,
                            onCheckedChange = {
                                viewModel.toggleDone(task.id)
                            }
                        )
                    }
                }
            }
        }
    }

    if (selectedTask != null) {
        DetailDialog(
            task = selectedTask!!,
            onClose = { viewModel.closeDialog() },
            onUpdate = { viewModel.updateTask(it) }
        )
    }
}
