package com.mesum.cleanarchtodos

import com.mesum.cleanarchtodos.model.Todo
import javax.inject.Inject
//h
class TodoRepository @Inject constructor(private val service: JsonPlaceholderService) {
    suspend fun fetchTodos(): List<Todo>{
      return  service.getTodos()
    }
}