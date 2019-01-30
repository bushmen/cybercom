package com.buszko.cybercom.adapter.viewholders

import android.view.View
import android.widget.TextView
import com.buszko.cybercom.viewmodels.postviewmodel.BasePostViewModel
import com.buszko.cybercom.R
import com.buszko.cybercom.viewmodels.postviewmodel.QuotePostViewModel

class QuotePostViewHolder(itemView: View) : BasePostViewHolder(itemView) {
    private val quoteTextView = itemView.findViewById<TextView>(R.id.quote_text)
    private val quoteSourceTextView = itemView.findViewById<TextView>(R.id.quote_source)

    override fun bind(post: BasePostViewModel) {
        post as QuotePostViewModel
        quoteTextView.text = post.quoteText
        quoteSourceTextView.text = post.quoteSource
    }
}