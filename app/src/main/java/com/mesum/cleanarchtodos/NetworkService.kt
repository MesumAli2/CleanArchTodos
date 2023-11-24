package com.mesum.cleanarchtodos

import com.mesum.cleanarchtodos.model.Todo
import retrofit2.http.GET

interface JsonPlaceholderService {
    @GET("todos")
    suspend fun getTodos(): List<Todo>
}
