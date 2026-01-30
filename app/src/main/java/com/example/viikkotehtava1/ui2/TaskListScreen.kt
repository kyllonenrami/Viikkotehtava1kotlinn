/*package com.example.viikkotehtava1.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.viikkotehtava1.domain.TaskViewModel
import androidx.compose.runtime.*
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.viikkotehtava1.domain.Task
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.viikkotehtava1.domain.TaskFilter
import com.example.viikkotehtava1.ui2.TaskRow


@Composable
fun TaskListScreen(
    taskViewModel: TaskViewModel


) {
    val tasks by taskViewModel.tasks.collectAsStateWithLifecycle()
    var newTitle by remember { mutableStateOf("") }
    var newDescription by remember { mutableStateOf("") }
    var newDueDate by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text("Tehtävät", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(8.dp))

        TaskFilterRow(
            onAll = { taskViewModel.setFilter(TaskFilter.ALL) },
            onDone = { taskViewModel.setFilter(TaskFilter.DONE) },
            onTodo = { taskViewModel.setFilter(TaskFilter.TODO) },
            onOrderByDueDate = { taskViewModel.toggleOrderByDueDate() }

        )

        Spacer(modifier = Modifier.height(8.dp))

        Column {
            TextField(
                value = newTitle,
                onValueChange = { newTitle = it },
                label = { Text("Otsikko") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = newDescription,
                onValueChange = { newDescription = it },
                label = { Text("Kuvaus") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = newDueDate,
                onValueChange = { newDueDate = it },
                label = { Text("Eräpäivä (YYYY-MM-DD)") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    if (newTitle.isNotBlank()) {
                        taskViewModel.addTask(
                            title = newTitle,
                            description = newDescription,
                            dueDate = newDueDate
                        )
                        newTitle = ""
                        newDescription = ""
                        newDueDate = ""
                    }
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Lisää")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(tasks) { task ->
                TaskRow(
                    task = task,
                    onToggleDone = taskViewModel::toggleDone,
                    onRemove = taskViewModel::removeTask
                )
            }
        }
    }
}
@Composable
fun TaskFilterRow(
    onAll: () -> Unit,
    onDone: () -> Unit,
    onTodo: () -> Unit,
    onOrderByDueDate: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(onClick = onAll) { Text("Kaikki") }
        Button(onClick = onDone) { Text("Valmiit") }
        Button(onClick = onTodo) { Text("Tekemättömät") }

        Button(onClick = onOrderByDueDate) { Text("Eräpäivä") }
    }
}


*/