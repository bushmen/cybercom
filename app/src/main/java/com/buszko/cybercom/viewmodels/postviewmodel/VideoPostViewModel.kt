package com.buszko.cybercom.viewmodels.postviewmodel

import com.buszko.cybercom.R
import com.buszko.cybercom.model.TumblrPost

class VideoPostViewModel(post: TumblrPost) : BasePostViewModel(post) {
    val videoUrl: String = post.videoSource ?: ""

    override fun getLayoutId(): Int {
        return R.layout.video_post_item
    }
}