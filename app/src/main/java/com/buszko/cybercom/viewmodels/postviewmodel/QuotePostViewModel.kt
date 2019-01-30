package com.buszko.cybercom.viewmodels.postviewmodel

import com.buszko.cybercom.R
import com.buszko.cybercom.model.TumblrPost

class QuotePostViewModel(post: TumblrPost) : BasePostViewModel(post) {
    val quoteText = "\"${post.quoteText}\""
    val quoteSource = "-${post.quoteSource}"

    override fun getLayoutId(): Int {
        return R.layout.quote_post_item
    }

}