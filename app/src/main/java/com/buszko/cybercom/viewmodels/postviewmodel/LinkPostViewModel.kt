package com.buszko.cybercom.viewmodels.postviewmodel

import com.buszko.cybercom.model.TumblrPost
import com.buszko.cybercom.R

class LinkPostViewModel(post: TumblrPost) : BasePostViewModel(post) {
    val linkUrl = post.linkUrl
    val linkText = post.linkText

    override fun getLayoutId(): Int {
        return R.layout.link_post_item
    }
}