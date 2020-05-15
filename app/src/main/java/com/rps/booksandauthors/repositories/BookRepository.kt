package com.rps.booksandauthors.repositories

import androidx.annotation.WorkerThread
import com.rps.booksandauthors.dao.BookDao
import com.rps.booksandauthors.entity.Book

class BookRepository(private val bookDao: BookDao) {
    @WorkerThread
    suspend fun insert(book: Book ){
        bookDao.insert(book)
    }

    @WorkerThread
    suspend fun insertBookList(bookList:List<Book>){
        bookDao.insertBookList(bookList);
    }

}