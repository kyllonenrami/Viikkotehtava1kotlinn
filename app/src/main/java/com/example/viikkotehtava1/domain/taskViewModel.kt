package com.example.viikkotehtava1.domain

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TaskViewModel : ViewModel() {

    private val _allTasks = MutableStateFlow<List<Task>>(emptyList())
    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks.asStateFlow()

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

    fun addTask(title: String) {
        val newId = (_allTasks.value.maxOfOrNull { it.id } ?: 0) + 1
        val newTask = Task(newId, title, "", 1, "", false)
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

    private fun applyFilter() {
        _tasks.value = when (currentFilter) {
            TaskFilter.ALL -> _allTasks.value
            TaskFilter.DONE -> _allTasks.value.filter { it.done }
            TaskFilter.TODO -> _allTasks.value.filter { !it.done }
        }
    }
}
