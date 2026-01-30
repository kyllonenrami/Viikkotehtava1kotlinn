package com.example.viikkotehtava1.domain

import androidx.compose.material3.Text
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.viikkotehtava1.view.HomeScreen


private var currentOrder = TaskOrder.NONE

class TaskViewModel : ViewModel() {

    private val _allTasks = MutableStateFlow<List<Task>>(emptyList())
    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks.asStateFlow()

    private val _selectedTask = MutableStateFlow<Task?>(null)

    val selectedTask: StateFlow<Task?> = _selectedTask

    private var currentFilter = TaskFilter.ALL

    init {
        val initialTasks = listOf(
            Task(1, "Osta maitoa", "Muista myös leipä", 1, "2026-02-01", false),
            Task(2, "Palauta tehtävä", "Ohjelmointi-kurssi", 3, "2026-01-25", true),
            Task(3, "Siivoa koti", "Keittiö ja olohuone", 2, "2026-02-10", false)
        )
        _allTasks.value = initialTasks
        applyFilter()
    }

    fun addTask(
        title: String,
        description: String,
        dueDate: String
    ) {
        val newId = (_allTasks.value.maxOfOrNull { it.id } ?: 0) + 1

        val newTask = Task(
            id = newId,
            title = title,
            description = description,
            priority = 1,
            dueDate = dueDate,
            done = false
        )

        _allTasks.value = _allTasks.value + newTask
        applyFilter()
    }


    fun toggleDone(id: Int) {
        _allTasks.value = _allTasks.value.map {
            if (it.id == id) it.copy(done = !it.done) else it
        }
        applyFilter()
    }

    fun removeTask(id: Int) {
        _allTasks.value = _allTasks.value.filterNot { it.id == id }
        applyFilter()
    }

    fun setFilter(filter: TaskFilter) {
        currentFilter = filter
        applyFilter()
    }
    fun selectTask(task: Task) {
        _selectedTask.value = task
    }
    private fun applyFilter() {
        val filtered = when (currentFilter) {
            TaskFilter.ALL -> _allTasks.value
            TaskFilter.DONE -> _allTasks.value.filter { it.done }
            TaskFilter.TODO -> _allTasks.value.filter { !it.done }
            TaskFilter.DUE_DATE -> _allTasks.value
        }

        _tasks.value = when (currentOrder) {
            TaskOrder.NONE -> filtered
            TaskOrder.DUE_DATE_ASC ->
                filtered.sortedBy { it.dueDate }

            TaskOrder.DUE_DATE_DESC ->
                filtered.sortedByDescending { it.dueDate }
        }
    }

    fun toggleOrderByDueDate() {
        currentOrder = when (currentOrder) {
            TaskOrder.NONE,
            TaskOrder.DUE_DATE_DESC -> TaskOrder.DUE_DATE_ASC

            TaskOrder.DUE_DATE_ASC -> TaskOrder.DUE_DATE_DESC
        }
        applyFilter()
    }
    fun updateTask(updated: Task) {
        _tasks.value = _tasks.value.map {
            if (it.id == updated.id) updated else it
        }
        _selectedTask.value = null
    }

    fun closeDialog() {
        _selectedTask.value = null
    }
}
