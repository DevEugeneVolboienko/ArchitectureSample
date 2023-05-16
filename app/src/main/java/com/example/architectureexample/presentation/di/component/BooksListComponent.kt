package com.example.architectureexample.presentation.di.component

import com.example.architectureexample.presentation.di.scope.ActivityScope
import com.example.architectureexample.presentation.ui.books_list.view.BooksListActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface BooksListComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): BooksListComponent
    }

    fun inject(booksListActivity: BooksListActivity)
}