package com.rps.booksandauthors.utils

import android.content.Context
import java.io.IOException

class ReadFileUtils {
    fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
            Log.d("Rohit---","Log File");
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
}
