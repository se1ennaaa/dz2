package com.example.dz2.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TaskModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dao(): TaskDao
}