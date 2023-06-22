package com.cvaghela.spinner.searchablespinner

import android.content.Context
import java.io.IOException

fun getJsonDataFromRaw(context: Context, fileName: Int): String {
    val jsonString: String
    try {
        jsonString =
            context.resources.openRawResource(fileName).bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return "null"
    }
    return jsonString
}

