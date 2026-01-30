package com.example.viikkotehtava1.domain


enum class TaskFilter {
    ALL,
    DONE,
    TODO,
    DUE_DATE
}
enum class TaskOrder {
    NONE,
    DUE_DATE_ASC,
    DUE_DATE_DESC
}