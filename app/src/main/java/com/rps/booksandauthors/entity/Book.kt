package com.rps.booksandauthors.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books_table")
data class Book(
    @PrimaryKey(autoGenerate = true) val id: Int, val title:String?, val isbn:String?, val pageCount:Int?,
    val publishedDate:String?, val thumbnailUrl:String?, val shortDescription:String?,
    val longDescription:String?, val status:String?, val authors:ArrayList<String>?, val categories:ArrayList<String>?) {
}
