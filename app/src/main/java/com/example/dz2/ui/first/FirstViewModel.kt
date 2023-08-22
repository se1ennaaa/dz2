package com.example.dz2.ui.first

import androidx.lifecycle.ViewModel
import com.example.dz2.data.local.TaskModel
import com.example.dz2.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(private val repository: Repository):ViewModel() {

    fun getData():List<TaskModel>{
        return repository.getData()
    }

    fun deleteData(taskModel: TaskModel){
        repository.deleteData(taskModel)
    }

    fun insertData(taskModel: TaskModel) {
        repository.insert(taskModel)
    }

    fun updateData(taskModel: TaskModel) {
        repository.updateData(taskModel)
    }


}