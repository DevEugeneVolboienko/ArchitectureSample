package com.example.architectureexample.presentation.ui.books_list.router

import android.content.Context
import android.content.Intent
import com.example.architectureexample.presentation.ui.book_info.view.BookInfoActivity

class BooksListRouterImpl(private val context: Context) : BooksListRouter {
    override fun loadBookInfoActivity() {
        val intent = Intent(context, BookInfoActivity::class.java)
        context.startActivity(intent)
    }
}