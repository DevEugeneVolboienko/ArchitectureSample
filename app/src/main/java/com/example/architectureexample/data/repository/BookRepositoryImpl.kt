package com.example.architectureexample.data.repository

import com.example.architectureexample.data.db.BookDAO
import com.example.architectureexample.data.entity.BookEntity
import com.example.architectureexample.data.mapper.toBookEntities
import com.example.architectureexample.data.network.BookApi
import com.example.architectureexample.domain.repository.BookRepository
import com.example.architectureexample.domain.response.BookResponse
import com.example.architectureexample.domain.response.BookType
import io.reactivex.Single
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookRepositoryImpl @Inject constructor(
    private val bookDAO: BookDAO, private val bookApi: BookApi
) : BookRepository {
    override fun getBooksByGenre(genre: BookType): Single<List<BookEntity>> =
        bookApi.getBooksListBy(genre.value)
            .compose(saveBooksToDatabase())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    private fun saveBooksToDatabase(): SingleTransformer<List<BookResponse>, List<BookEntity>> =
        SingleTransformer { bookResponses ->
            Timber.d(bookResponses.toString())
            bookResponses.map { it.toBookEntities() }.doAfterSuccess {
                saveBooks(it)
            }
        }

    private fun saveBooks(bookEntities: List<BookEntity>) {
        bookDAO.insertAll(bookEntities)
    }
}