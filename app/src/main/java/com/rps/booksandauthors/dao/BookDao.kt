package com.rps.booksandauthors.dao

import androidx.room.Dao
import androidx.room.Insert
import com.rps.booksandauthors.entity.Book

@Dao
interface BookDao {
    @Insert
    suspend fun insert(book : Book)
}