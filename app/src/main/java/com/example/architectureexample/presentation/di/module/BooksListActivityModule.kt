package com.example.architectureexample.presentation.di.module

import com.example.architectureexample.presentation.ui.books_list.router.BooksListRouter
import com.example.architectureexample.presentation.ui.books_list.router.BooksListRouterImpl
import com.example.architectureexample.presentation.ui.books_list.view.BooksListActivity
import dagger.Module
import dagger.Provides

@Module
class BooksListActivityModule {
    @Provides
    fun provideRouter(booksListActivity: BooksListActivity): BooksListRouter =
        BooksListRouterImpl(booksListActivity)
}