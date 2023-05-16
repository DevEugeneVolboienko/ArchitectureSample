package com.example.architectureexample.domain.response.adapter

import com.example.architectureexample.domain.response.BookType
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import timber.log.Timber

class BookTypeAdapter {
    @ToJson
    fun toJson(type: BookType): String = type.value.also {
        Timber.d("BookTypeAdapter.toJson $it")
    }

    @FromJson
    fun fromJson(value: String): BookType = BookType.from(value).also {
        Timber.d("BookTypeAdapter.fromJson $value")
    }
}