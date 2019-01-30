package com.buszko.cybercom.viewmodels.postviewmodel

import com.buszko.cybercom.model.TumblrPost

abstract class BasePostViewModel(post: TumblrPost) {
    abstract fun getLayoutId(): Int
}