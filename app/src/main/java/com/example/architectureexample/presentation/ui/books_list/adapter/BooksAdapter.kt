package com.example.architectureexample.presentation.ui.books_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.architectureexample.databinding.ItemBookBinding
import com.example.architectureexample.presentation.ui.base.BaseAdapter
import com.example.architectureexample.presentation.ui.base.BaseViewHolder
import com.example.architectureexample.presentation.ui.base.listener.OnItemClickListener
import com.example.architectureexample.presentation.ui.books_list.viewmodel.BookViewModel

class BooksAdapter(
    data: List<BookViewModel>,
    onItemClickListener: OnItemClickListener<BookViewModel>
) : BaseAdapter<ItemBookBinding, BookViewModel, BooksAdapter.BookViewHolder>(
    data,
    onItemClickListener
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder =
        BookViewHolder(ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    inner class BookViewHolder(private val viewBinding: ItemBookBinding) :
        BaseViewHolder<ItemBookBinding, BookViewModel>(viewBinding) {
        override fun bind(viewModel: BookViewModel) {
            with(viewBinding) {
                this.viewModel = viewModel
                root.setOnClickListener {
                    onItemClickListener.onClick(viewModel)
                }
                executePendingBindings()
            }
        }
    }
}