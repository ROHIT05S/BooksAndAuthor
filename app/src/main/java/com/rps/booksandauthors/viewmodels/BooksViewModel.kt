package com.rps.booksandauthors.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.rps.booksandauthors.database.BooksDatabase
import com.rps.booksandauthors.entity.Book
import com.rps.booksandauthors.repositories.BookRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.lifecycle.LiveData

class BooksViewModel(application: Application) : AndroidViewModel(application) {
    val bookRepository : BookRepository
    init {
        val bookDao = BooksDatabase.getDatabase(application).bookDao()
        bookRepository = BookRepository(bookDao)
    }
    fun insert(book: Book) = viewModelScope.launch(Dispatchers.IO) {
        bookRepository.insert(book)
    }
}