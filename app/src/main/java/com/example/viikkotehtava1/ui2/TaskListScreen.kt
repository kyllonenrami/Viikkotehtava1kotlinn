package com.example.viikkotehtava1.ui

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
    taskViewModel: TaskViewModel = viewModel()
) {
    val tasks by taskViewModel.tasks.collectAsStateWithLifecycle()
    var newTitle by remember { mutableStateOf("") }

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
            onTodo = { taskViewModel.setFilter(TaskFilter.TODO) }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row {
            TextField(
                value = newTitle,
                onValueChange = { newTitle = it },
                modifier = Modifier.weight(1f),
                label = { Text("Uusi tehtävä") }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                if (newTitle.isNotBlank()) {
                    taskViewModel.addTask(newTitle)
                    newTitle = ""
                }
            }) {
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
    onTodo: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(onClick = onAll) { Text("Kaikki") }
        Button(onClick = onDone) { Text("Valmiit") }
        Button(onClick = onTodo) { Text("Tekemättömät") }
    }
}

