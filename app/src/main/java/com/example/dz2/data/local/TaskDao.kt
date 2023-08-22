package com.example.dz2.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDao {

    @Query("SELECT * FROM task_list ORDER BY id DESC")
    fun getList(): List<TaskModel>

    @Insert
    fun addData(taskModel: TaskModel)

    @Delete
    fun deleteData(taskModel: TaskModel)

    @Update
    fun updateData(taskModel: TaskModel)
}