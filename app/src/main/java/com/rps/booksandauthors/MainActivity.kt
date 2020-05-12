package com.rps.booksandauthors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rps.booksandauthors.entity.BookList
import com.rps.booksandauthors.utils.ReadFileUtils

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       /* val readFileUtils:ReadFileUtils? = ReadFileUtils()
        val jsonFileString = readFileUtils?.getJsonDataFromAsset(this, "books.json")
        Log.d("dataFromFile ------", jsonFileString)

        val gson = Gson()

        val booksList1  = object :TypeToken<BookList>(){}.type

        Log.d("BooksList1--Data---", "ListBooks"+booksList1)

        var books: BookList = gson.fromJson(jsonFileString, booksList1)

        Log.d("dataFromFile ------", "ListBooks"+books.booksList)
//        books.forEachIndexed { idx, person -> Log.i("Each data -------", "> Item $idx:\n$person") }*/
    }
}
