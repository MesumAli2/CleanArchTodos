package com.mesum.cleanarchtodos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.mesum.cleanarchtodos.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: TodoViewModel by viewModels()
    private val adapter = RvAdapter()
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.todos.observe(this) { todos ->
            Log.d("TodosRv", todos.toString())
            binding.rvTodos.adapter = adapter
            binding.rvTodos.layoutManager = LinearLayoutManager(this)
            adapter.submitList(todos)
        }

        viewModel.fetchTodos()

    }
}