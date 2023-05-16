package com.example.architectureexample.data.mapper

import com.example.architectureexample.data.entity.BookEntity
import com.example.architectureexample.domain.response.BookResponse
import com.example.architectureexample.domain.response.BookType
import timber.log.Timber

fun BookResponse.toBookEntity(): BookEntity = BookEntity(id!!, name!!, type!!.value, available!!)

fun BookEntity.toBookResponse() = BookResponse(id, name, BookType.valueOf(genre), isAvailable)

fun List<BookResponse>.toBookEntities() = apply { Timber.d(toString()) }
    .asSequence()
    .filter { it.id != null }
    .filter { !it.name.isNullOrEmpty() }
    .filter { it.type != null }
    .filter { it.type != BookType.UNKNOWN }
    .filter { it.available != null }
    .map { it.toBookEntity() }
    .toList()

fun List<BookEntity>.toBookResponses() = map { it.toBookResponse() }
