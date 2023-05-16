package com.example.architectureexample.presentation.ui.books_list.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import com.example.architectureexample.data.TIMBER_MSG_SUCCESS_GET_BOOKS
import com.example.architectureexample.domain.usecase.GetBooksUseCase
import com.example.architectureexample.domain.response.BookType
import com.example.architectureexample.presentation.di.scope.ActivityScope
import com.example.architectureexample.presentation.ui.base.BaseViewModel
import com.example.architectureexample.presentation.ui.base.listener.OnItemClickListener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

@ActivityScope
class BooksListViewModel @Inject constructor(
    private val getBooksUseCase: GetBooksUseCase
    // TODO: inject router
    // private val booksListRouter: BooksListRouter
) : BaseViewModel() {
    private val _navigateToBookDetails = MutableLiveData<BookViewModel>()
    val navigateToBookDetails
        get() = _navigateToBookDetails
    val booksList = ObservableArrayList<BookViewModel>()
    val onItemClickListener by lazy {
        object : OnItemClickListener<BookViewModel> {
            override fun onClick(item: BookViewModel) {
                onBookClicked(item)
            }
        }
    }

    fun getBooks(genre: BookType) {
        disposables.add(
            getBooksUseCase.getBooksBy(genre)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    onBooksLoaded(),
                    onBooksLoadingError()
                )
        )
    }

    private fun onBookClicked(bookViewModel: BookViewModel) {
        navigateToBookDetails.value = bookViewModel
    }

    fun onBookDetailsNavigated() {
        navigateToBookDetails.value = null
    }

    private fun onBooksLoaded(): (booksList: List<BookViewModel>) -> Unit =
        {
            Timber.d(TIMBER_MSG_SUCCESS_GET_BOOKS)
            booksList.clear()
            booksList.addAll(it)
        }

    private fun onBooksLoadingError(): (t: Throwable) -> Unit = {
        Timber.d(it)
    }
}