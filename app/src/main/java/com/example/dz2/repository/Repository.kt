package com.example.dz2.repository

import com.example.dz2.data.local.TaskDao
import com.example.dz2.data.local.TaskModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class Repository @Inject constructor(private val dao: TaskDao) {

    fun getData(): List<TaskModel> {
        return dao.getList()
    }

    fun insert(taskModel: TaskModel) {
        dao.addData(taskModel)
    }


    fun deleteData(taskModel: TaskModel) {
        dao.deleteData(taskModel)
    }

    fun updateData(taskModel: TaskModel) {
        dao.updateData(taskModel)
    }

}