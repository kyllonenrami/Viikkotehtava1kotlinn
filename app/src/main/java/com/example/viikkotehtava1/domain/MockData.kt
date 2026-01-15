package com.example.viikkotehtava1.domain

val mockTasks = listOf(
    Task(
        id = 1,
        title = "Osta ruokaa",
        description = "Maito, leipä ja kana",
        priority = 1,
        dueDate = "2025-12-12",
        done = true
    ),
    Task(
        id = 2,
        title = "Tee koulutehtävät",
        description = "Viikon 1 tehtävä",
        priority = 2,
        dueDate = "2025-11-12",
        done = false
    ),
    Task(
        id = 3,
        title = "Täytä tiskikone",
        description = "Laita astiat koneeseen",
        priority = 1,
        dueDate = "2025-11-11",
        done = false
    ),
    Task(
        id = 4,
        title = "Katso sähköpostit",
        description = "Onko tullut tärkeitä viestejä",
        priority = 1,
        dueDate = "2025-10-10",
        done = true
    ),
    Task(
        id = 5,
        title = "Käytä koira",
        description = "30 minuutin iltalenkki",
        priority = 2,
        dueDate = "2025-12-17",
        done = true
    )
)