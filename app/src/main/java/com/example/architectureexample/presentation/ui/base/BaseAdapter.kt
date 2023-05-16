package com.example.architectureexample.presentation.ui.base

import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.architectureexample.presentation.ui.base.listener.OnItemClickListener

abstract class BaseAdapter<VB : ViewBinding, VM : ViewModel, VH : BaseViewHolder<VB, VM>>(
    protected val data: List<VM>,
    val onItemClickListener: OnItemClickListener<VM>
) : RecyclerView.Adapter<VH>() {
    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH
}