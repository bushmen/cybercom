package com.buszko.cybercom.viewmodels.postviewmodel

import com.buszko.cybercom.R
import com.buszko.cybercom.model.TumblrPost

class LoadingPostViewModel(post: TumblrPost) : BasePostViewModel(post) {
    override fun getLayoutId(): Int {
        return R.layout.loader
    }
}