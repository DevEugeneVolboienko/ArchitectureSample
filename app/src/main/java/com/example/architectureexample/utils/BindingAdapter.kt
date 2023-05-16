package com.example.architectureexample.utils

import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.architectureexample.presentation.ui.base.listener.OnItemClickListener
import com.example.architectureexample.presentation.ui.books_list.adapter.BooksAdapter
import com.example.architectureexample.presentation.ui.books_list.viewmodel.BookViewModel

@BindingAdapter("isBookAvailable")
fun ImageView.setIsBookAvailable(isAvailable: Boolean) {
    val drawable = ContextCompat.getDrawable(
        this.context,
        if (isAvailable) android.R.drawable.checkbox_on_background else android.R.drawable.checkbox_off_background
    )
    setImageDrawable(drawable)
}

// TODO: Update with generics
@BindingAdapter("items", "onClickListener")
fun RecyclerView.bindData(
    books: List<BookViewModel>,
    onClickListener: OnItemClickListener<BookViewModel>
) {
    adapter = BooksAdapter(books, onClickListener).also {
        it.notifyDataSetChanged()
    }
}