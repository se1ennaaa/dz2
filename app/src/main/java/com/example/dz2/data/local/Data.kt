package com.example.dz2.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "task_list")
data class TaskModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val title: String? = null,
    val desc: String? = null,
    val check: Boolean? = false
) : Serializable
