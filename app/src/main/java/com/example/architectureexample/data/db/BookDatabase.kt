package com.example.architectureexample.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.architectureexample.data.entity.BookEntity

private const val DATABASE_VERSION = 3

@Database(entities = [BookEntity::class], version = DATABASE_VERSION, exportSchema = false)
abstract class BookDatabase : RoomDatabase() {
    abstract fun bookDAO(): BookDAO
}