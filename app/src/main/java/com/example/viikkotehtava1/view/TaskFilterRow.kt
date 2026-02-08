package com.example.viikkotehtava1.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TaskFilterRow(
    onAll: () -> Unit,
    onDone: () -> Unit,
    onTodo: () -> Unit,
    onOrderByDueDate: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(onClick = onAll) {
            Text("Kaikki")
        }
        Button(onClick = onDone) {
            Text("Valmiit")
        }
        Button(onClick = onTodo) {
            Text("Tekemättömät")
        }
        Button(onClick = onOrderByDueDate) {
            Text("Eräpäivä")
        }
    }
}
