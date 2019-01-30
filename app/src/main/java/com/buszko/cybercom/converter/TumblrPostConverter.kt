package com.buszko.cybercom.converter

import com.buszko.cybercom.model.PostType
import com.buszko.cybercom.model.TumblrPost
import com.buszko.cybercom.viewmodels.postviewmodel.*

/*
* I have supported only those types of posts since I didn't have any idea to present conversation and
* audio in friendly way, which will present any more skills :).
* */
class TumblrPostConverter {
    companion object {
        fun convert(items: List<TumblrPost>): List<BasePostViewModel> {
            val viewModels = ArrayList<BasePostViewModel>()
            loop@ for (item in items) {
                when (item.type) {
                    PostType.photo -> viewModels.add(PhotoPostViewModel(item))
                    PostType.quote -> viewModels.add(QuotePostViewModel(item))
                    PostType.video -> {
                        val videoUrl = item.videoSource
                        if (videoUrl != null && !videoUrl.isEmpty()) {
                            viewModels.add(VideoPostViewModel(item))
                        }
                    }
                    PostType.link -> viewModels.add(LinkPostViewModel(item))
                    else -> continue@loop
                }
            }
            return viewModels
        }
    }
}