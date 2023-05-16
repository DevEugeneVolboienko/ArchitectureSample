package com.example.architectureexample.domain.usecase

import com.example.architectureexample.domain.response.BookType
import com.example.architectureexample.presentation.ui.books_list.viewmodel.BookViewModel
import io.reactivex.Single

interface GetBooksUseCase {
    fun getBooksBy(genre: BookType): Single<List<BookViewModel>>
}