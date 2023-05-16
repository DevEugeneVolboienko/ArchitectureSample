package com.example.architectureexample.data

import com.example.architectureexample.presentation.ui.books_list.viewmodel.BookViewModel

const val OBJECTS_COUNT = 20

fun mockBookViewModelList(): List<BookViewModel> = arrayListOf<BookViewModel>().apply {
    for (i in 0..OBJECTS_COUNT) {
        this.add(BookViewModel().apply {
            id.set(i)
            name.set("Name $i")
            genre.set("Genre $i")
            isAvailable.set(i % 2 == 0)
        })
    }
}