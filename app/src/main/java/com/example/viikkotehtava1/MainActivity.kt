package com.example.viikkotehtava1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.viikkotehtava1.domain.*
import com.example.viikkotehtava1.ui.theme.HomeScreen
import com.example.viikkotehtava1.ui.theme.Viikkotehtava1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Viikkotehtava1Theme {
                TaskApp() //HomeScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskApp() {

    var taskList by remember { mutableStateOf(mockTasks) }
    val name = "Uusi task"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        // ADD TASK
        Button(
            onClick = {
                val newTask = Task(
                    id = taskList.size + 1,
                    title = name,
                    description = "Description",
                    priority = 1,
                    dueDate = "2025-11-10",
                    done = false
                )
                taskList = addTask(taskList, newTask)
            }
        ) {
            Text("Lisää uusi task")
        }

        // TOGGLE DONE (id = 1)
        Button(
            onClick = {
                taskList = toggleDone(taskList, id = 1)
            }
        ) {
            Text("Toggle done (id=1)")
        }

        // FILTER DONE
        Button(
            onClick = {
                taskList = filterByDone(taskList, done = true)
            }
        ) {
            Text("Näytä valmiit")
        }

        // FILTER NOT DONE
        Button(
            onClick = {
                taskList = filterByDone(taskList, done = false)
            }
        ) {
            Text("Näytä keskeneräiset")
        }

        // SORT BY DATE
        Button(
            onClick = {
                taskList = sortByDueDate(taskList)
            }
        ) {
            Text("Järjestä päivämäärän mukaan")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // TASK LIST (näyttöä varten)
        taskList.forEach { task ->
            Text("${task.id}. ${task.title} | done=${task.done} | ${task.dueDate}")
        }
    }
}
