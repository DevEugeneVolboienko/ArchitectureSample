package com.example.architectureexample.presentation.di.module

import androidx.room.Room
import com.example.architectureexample.core.App
import com.example.architectureexample.data.db.BookDAO
import com.example.architectureexample.data.db.BookDatabase
import com.example.architectureexample.data.network.BookApi
import com.example.architectureexample.data.repository.BookRepositoryImpl
import com.example.architectureexample.data.interactor.GetBooksInteractor
import com.example.architectureexample.domain.repository.BookRepository
import com.example.architectureexample.domain.usecase.GetBooksUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

private const val DATABASE_NAME = "books.db"

@Module
class RoomModule {
    @Singleton
    @Provides
    fun provideBookDatabase(app: App): BookDatabase =
        Room.databaseBuilder(app, BookDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideBookDao(bookDatabase: BookDatabase): BookDAO = bookDatabase.bookDAO()

    @Singleton
    @Provides
    fun provideBookRepository(bookDAO: BookDAO, bookApi: BookApi): BookRepository =
        BookRepositoryImpl(bookDAO, bookApi)

    @Singleton
    @Provides
    fun provideGetBooksUseCase(bookRepository: BookRepository): GetBooksUseCase =
        GetBooksInteractor(bookRepository)
}