package com.mesum.cleanarchtodos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mesum.cleanarchtodos.model.Todo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor (private val fetchTodoUseCase: FetchTodoUseCase): ViewModel() {
    private val _todos = MutableLiveData<List<Todo>>()
    val todos: LiveData<List<Todo>> get() = _todos

    fun fetchTodos(){
        viewModelScope.launch {
            try {
                val fetchedTodos = fetchTodoUseCase.invoke()
                _todos.postValue(fetchedTodos)

            }catch (e: HttpException){
                _todos.postValue(emptyList())

            }catch (e: Exception){
                _todos.postValue(emptyList())

            }
        }
    }
}