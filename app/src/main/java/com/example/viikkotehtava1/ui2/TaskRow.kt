package com.example.viikkotehtava1.ui2
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.viikkotehtava1.domain.Task


@Composable
fun TaskRow(
    task: Task,
    onToggleDone: (Int) -> Unit,
    onRemove: (Int) -> Unit,
    onClick: (Task) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                println("CLICKED: ${task.title}")
                onClick(task)
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(
                checked = task.done,
                onCheckedChange = { onToggleDone(task.id) }
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(task.title, style = MaterialTheme.typography.bodyLarge)

                if (task.description.isNotBlank()) {
                    Text(task.description, style = MaterialTheme.typography.bodySmall)
                }

                Text(
                    text = "Deadline: ${task.dueDate.ifBlank { "ei asetettu" }} | Prioriteetti: ${task.priority}",
                    style = MaterialTheme.typography.labelSmall
                )
            }

            IconButton(onClick = { onRemove(task.id) }) {
                Icon(Icons.Default.Delete, contentDescription = "Poista")
            }
        }
    }
}
