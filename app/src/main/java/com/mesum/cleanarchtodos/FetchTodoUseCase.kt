package com.mesum.cleanarchtodos

import com.mesum.cleanarchtodos.model.Todo
import javax.inject.Inject

class FetchTodoUseCase @Inject constructor(private val repository: TodoRepository) {
    suspend operator fun invoke():List<Todo>{
        return repository.fetchTodos()
    }
}