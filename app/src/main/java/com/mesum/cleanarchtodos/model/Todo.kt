package com.mesum.cleanarchtodos.model

data class Todo (
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)