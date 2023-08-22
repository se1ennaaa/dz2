package com.example.dz2.ui.first

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dz2.data.local.TaskModel
import com.example.dz2.databinding.ItemListBinding

class TaskAdapter(
    val deleteClick: (TaskModel) -> Unit,
    val onClick: (TaskModel) -> Unit,
    val onClickOnCheckBox: (TaskModel) -> Unit
) :
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    private var list = mutableListOf<TaskModel>()

    fun addData(lists: List<TaskModel>) {
        list.clear()
        list.addAll(lists)
        list.sortByDescending { it.check }
        notifyDataSetChanged()
    }

    fun addTrueCheckBox(taskModel: TaskModel){
        if (taskModel.check == true) {
            list.add(0, taskModel) // Добавляем в начало списка
            notifyItemInserted(0)
        }
    }

    fun deleteData(lists: TaskModel) {
        list.remove(lists)
        notifyItemChanged(0)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    inner class TaskViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(taskModel: TaskModel) {
            binding.tvTitle.text = taskModel.title
            binding.tvDesc.text = taskModel.desc
            binding.checkBox.setOnCheckedChangeListener(null) // Удалите существующий обработчик, чтобы избежать рекурсивного вызова

            binding.checkBox.isChecked = taskModel.check ?: false

            binding.checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
                val updatedTaskModel = taskModel.copy(check = isChecked)
                onClickOnCheckBox(updatedTaskModel)
            }

            itemView.setOnLongClickListener {
                deleteClick(taskModel)
                false
            }
            itemView.setOnClickListener {
                onClick(taskModel)
            }
        }

    }
}