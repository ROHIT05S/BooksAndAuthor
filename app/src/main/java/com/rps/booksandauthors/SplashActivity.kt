package com.rps.booksandauthors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rps.booksandauthors.entity.Book
import com.rps.booksandauthors.entity.BookList
import com.rps.booksandauthors.utils.ReadFileUtils
import com.rps.booksandauthors.viewmodels.BooksViewModel

class SplashActivity : AppCompatActivity() {


    lateinit var booksViewModel : BooksViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        booksViewModel = ViewModelProvider(this).get(BooksViewModel::class.java)
        fetchAndSaveBookDetail()


    }

    fun fetchAndSaveBookDetail() {
        val readFileUtils: ReadFileUtils? = ReadFileUtils()
        val jsonFileString = readFileUtils?.getJsonDataFromAsset(this, "books.json")
        Log.d("dataFromFile ------", jsonFileString)

        val gson = Gson()

        val booksList1  = object : TypeToken<BookList>(){}.type

        Log.d("BooksList1--Data---", "ListBooks"+booksList1)

        var books: BookList = gson.fromJson(jsonFileString, booksList1)

        saveDataToDatabase1(books.booksList)

       /* for (book in books.booksList){
            saveDataToDatabase(book)
        }*/
    }

    fun saveDataToDatabase(
        book: Book
    ) {
        booksViewModel.insert(book)

        Toast.makeText(this,"Your Data Is Saved", Toast.LENGTH_SHORT).show()
    }
    fun saveDataToDatabase1(
        bookList: List<Book>
    ) {
        booksViewModel.insertBookList(bookList)

        Toast.makeText(this,"Your Data Is Saved", Toast.LENGTH_SHORT).show()
    }
}
