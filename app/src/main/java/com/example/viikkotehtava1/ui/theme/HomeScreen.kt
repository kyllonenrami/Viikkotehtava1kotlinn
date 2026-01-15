package com.example.viikkotehtava1.ui.theme


import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.viikkotehtava1.domain.Task
import com.example.viikkotehtava1.domain.mockTasks

@Composable
fun HomeScreen(
    tasks: List<Task> = mockTasks
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // OTSIKKO
        Text(
            text = "Tehtävälista",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // TASK-LISTA
        tasks.forEach { task ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                Text(
                    text = "${task.id}.",
                    modifier = Modifier.width(24.dp)
                )

                Column {
                    Text(text = task.title)
                    Text(
                        text = "Due: ${task.dueDate} | Done: ${task.done}",
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}


