package com.buszko.cybercom.adapter.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import com.buszko.cybercom.viewmodels.postviewmodel.BasePostViewModel

abstract class BasePostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(post: BasePostViewModel)
}