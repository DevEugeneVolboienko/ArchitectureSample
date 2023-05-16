package com.example.architectureexample.presentation.di.component

import com.example.architectureexample.presentation.di.module.AppModule
import com.example.architectureexample.presentation.di.module.NetworkModule
import com.example.architectureexample.presentation.di.module.RoomModule
import com.example.architectureexample.presentation.ui.book_info.view.BookInfoActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, RoomModule::class])
interface AppComponent {
    fun booksListComponent(): BooksListComponent.Factory

    fun inject(bookInfoActivity: BookInfoActivity)
}