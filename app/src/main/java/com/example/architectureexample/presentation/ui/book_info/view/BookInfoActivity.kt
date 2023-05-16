package com.example.architectureexample.presentation.ui.book_info.view

import android.os.Bundle
import com.example.architectureexample.R
import com.example.architectureexample.core.App
import com.example.architectureexample.presentation.ui.base.BaseActivity
import com.example.architectureexample.presentation.ui.book_info.viewmodel.BookInfoViewModel
import javax.inject.Inject

class BookInfoActivity : BaseActivity() {
    @Inject
    lateinit var bookInfoViewModel: BookInfoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_info)
    }
}