package com.rps.booksandauthors.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

import com.rps.booksandauthors.dao.BookDao
import com.rps.booksandauthors.entity.Book
import com.rps.booksandauthors.utils.Converters

@Database(entities = [Book::class], version = 1)
abstract class BooksDatabase:RoomDatabase() {
    abstract fun bookDao(): BookDao
    companion object {
        @Volatile
        private var INSTANCE: BooksDatabase? = null

        fun getDatabase(context: Context
        ): BooksDatabase {
            val tempInstance = INSTANCE
            if (tempInstance !=null ) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BooksDatabase::class.java,
                    "books_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}