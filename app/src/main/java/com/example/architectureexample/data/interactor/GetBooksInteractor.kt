package com.example.architectureexample.data.interactor

import com.example.architectureexample.domain.repository.BookRepository
import com.example.architectureexample.domain.response.BookType
import com.example.architectureexample.domain.usecase.GetBooksUseCase
import com.example.architectureexample.presentation.mapper.mapBooks
import com.example.architectureexample.presentation.ui.books_list.viewmodel.BookViewModel
import io.reactivex.Single
import javax.inject.Inject

class GetBooksInteractor @Inject constructor(private val bookRepository: BookRepository) :
    GetBooksUseCase {
    override fun getBooksBy(genre: BookType): Single<List<BookViewModel>> =
        bookRepository.getBooksByGenre(genre).compose(mapBooks())
}