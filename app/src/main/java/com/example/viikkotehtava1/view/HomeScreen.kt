package com.example.viikkotehtava1.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.viikkotehtava1.domain.Task
import com.example.viikkotehtava1.domain.TaskFilter
import com.example.viikkotehtava1.domain.TaskViewModel
//import com.example.viikkotehtava1.ui.TaskListScreen
import com.example.viikkotehtava1.ui2.TaskRow
//import com.example.viikkotehtava1.ui.TaskFilterRow




@Composable
fun HomeScreen(
    viewModel: TaskViewModel = viewModel()

) {
    val selectedTask by viewModel.selectedTask.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        TaskListScreen(taskViewModel = viewModel)
    }

    if (selectedTask != null) {
        DetailDialog(
            task = selectedTask!!,
            onClose = { viewModel.closeDialog() },
            onUpdate = { viewModel.updateTask(it) }
        )
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
                    taskViewModel.addTask(newTitle, newDescription, newDueDate)
                    newTitle = ""
                    newDescription = ""
                    newDueDate = ""
                }
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Lisää")
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(tasks) { task ->
                TaskRow(
                    task = task,
                    onToggleDone = taskViewModel::toggleDone,
                    onRemove = taskViewModel::removeTask,
                    onClick = taskViewModel::selectTask
                )
            }
        }
    }
}
