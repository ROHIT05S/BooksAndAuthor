package com.rps.booksandauthors.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.rps.booksandauthors.database.BooksDatabase
import com.rps.booksandauthors.entity.Book
import com.rps.booksandauthors.repositories.BookRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    val bookRepository : BookRepository
//    val allToDoData: LiveData<List<ToDoEntity>> get() = toDorepository.todos
    val toDoClassName: String = "ToDoFragmentViewModel"
    init {
        val bookDao = BooksDatabase.getDatabase(application).bookDao()
        bookRepository = BookRepository(bookDao)
    }


    fun insert(book: Book) = viewModelScope.launch(Dispatchers.IO) {
        bookRepository.insert(book)
    }
}