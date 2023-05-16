package com.example.architectureexample.presentation.mapper

import android.view.View
import com.example.architectureexample.data.entity.BookEntity
import com.example.architectureexample.presentation.ui.books_list.viewmodel.BookViewModel
import io.reactivex.SingleTransformer
import timber.log.Timber

fun mapBooks(): SingleTransformer<List<BookEntity>, List<BookViewModel>> =
    SingleTransformer { bookEntitiesSingle ->
        bookEntitiesSingle.map { bookEntities ->
            Timber.d(bookEntities.toString())
            bookEntities.map {
                BookViewModel().apply {
                    id.set(it.id)
                    name.set(it.name)
                    genre.set(it.genre)
                    isAvailableVisibility.set(View.VISIBLE)
                    isAvailable.set(it.isAvailable)
                }
            }
        }
    }