package com.example.architectureexample.presentation.ui.books_list.view

import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.architectureexample.R
import com.example.architectureexample.core.App
import com.example.architectureexample.databinding.ActivityBooksListBinding
import com.example.architectureexample.domain.response.BookType
import com.example.architectureexample.presentation.ui.base.BaseActivity
import com.example.architectureexample.presentation.ui.books_list.viewmodel.BooksListViewModel
import javax.inject.Inject

class BooksListActivity : BaseActivity() {
    @Inject
    lateinit var booksListViewModel: BooksListViewModel

    private lateinit var binding: ActivityBooksListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as App).appComponent.booksListComponent().create().inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_books_list)
        binding.viewModel = booksListViewModel
        booksListViewModel.navigateToBookDetails.observe(this) {
            // TODO: add route to new activity
            Toast.makeText(this, "${it.id.get()}", Toast.LENGTH_SHORT).show()
        }
        booksListViewModel.getBooks(BookType.FICTION)
    }

    override fun onDestroy() {
        super.onDestroy()
        // TODO: release resources the proper way
        booksListViewModel.onBookDetailsNavigated()
    }
}