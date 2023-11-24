package com.mesum.cleanarchtodos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mesum.cleanarchtodos.model.Todo

val diffUtil: DiffUtil.ItemCallback<Todo> = object : DiffUtil.ItemCallback<Todo>() {
    override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
        return oldItem.id == newItem.id
    }
}
class RvAdapter: ListAdapter<Todo,RvAdapter.TodoViewHolder >(diffUtil) {

    inner class TodoViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView){
        val todoTitle = itemView.findViewById<TextView>(R.id.to_do_text)
        val todoCompleteCheck = itemView.findViewById<CheckBox>(R.id.todo_completed)
        fun bind(todo: Todo){
            todoTitle.text = todo.title
            todoCompleteCheck.isChecked = todo.completed
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.todo_view, parent, false))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}