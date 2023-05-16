package com.example.architectureexample.domain.repository

import com.example.architectureexample.data.entity.BookEntity
import com.example.architectureexample.domain.response.BookType
import io.reactivex.Single

interface BookRepository {
    fun getBooksByGenre(genre: BookType): Single<List<BookEntity>>
}