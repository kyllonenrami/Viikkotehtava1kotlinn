package com.example.viikkotehtava1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import com.example.viikkotehtava1.ui.theme.Viikkotehtava1Theme
import com.example.viikkotehtava1.ui.TaskListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Viikkotehtava1Theme {
                TaskListScreen()
            }
        }
    }
}

/*@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    var taskList by remember { mutableStateOf(mockTasks) }

    var filterDone by remember { mutableStateOf<Boolean?>(null) }

    val visibleList = when (filterDone) {
        null -> taskList
        else -> filterByDone(taskList,filterDone!!)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Task List",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Button(onClick = {
                val newTask = Task(
                    id = taskList.size + 1,
                    title = "New Task",
                    description = "This is a new task",
                    priority = 2,
                    dueDate = "2025-11-11",
                    done = false
                )
                taskList = addTask(taskList, newTask)
            }) {
                Text("Add Task")
            }

            //Filtteri
            Button(onClick =  {
                filterDone = when (filterDone) {
                    null -> false
                    false -> true
                    true -> null
                }
            }) {
                Text(
                    when (filterDone) {
                        null -> "Filter: All"
                        false -> "Filter: Todo"
                        true -> "Filter: Done"
                    }
                )
            }


            Button(onClick =  {
                taskList = sortByDueDate(taskList)
            }) {
                Text("Sort")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        visibleList.forEach { task ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column(modifier = Modifier.weight(1f)) {
                    Text(text = task.title)
                    Text(
                        text = "Due: ${task.dueDate}",
                        style = MaterialTheme.typography.bodySmall
                    )
                    Text(
                        text = "Done: ${task.done}",
                        style = MaterialTheme.typography.bodySmall
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Button(onClick = {
                    taskList = toggleDone(taskList, task.id)
                }) {
                    Text("Toggle")
                }
            }
        }
    }
}*/