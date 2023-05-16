package com.example.architectureexample.presentation.ui.books_list.viewmodel

import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import com.example.architectureexample.presentation.ui.base.BaseViewModel

class BookViewModel : BaseViewModel() {
    val id: ObservableInt = ObservableInt()
    val name = ObservableField<String>()
    val genre = ObservableField<String>()
    val isAvailable = ObservableBoolean()
    val isAvailableVisibility = ObservableInt(View.VISIBLE)
}