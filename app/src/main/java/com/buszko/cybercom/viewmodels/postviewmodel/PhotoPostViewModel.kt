package com.buszko.cybercom.viewmodels.postviewmodel

import com.buszko.cybercom.R
import com.buszko.cybercom.model.TumblrPost

class PhotoPostViewModel(post: TumblrPost) : BasePostViewModel(post) {
    private val hrefRegex = "<a\\s+(?:[^>]*?\\s+)?href=([\"'])(.*?)\\1"

    var photoUrl: String = post.photos!![0]
    var contentUtl: String = getCaptionUrl(post.photoCaption)

    override fun getLayoutId(): Int {
        return R.layout.photo_post_item
    }

    private fun getCaptionUrl(caption: String?): String {
        val regex = Regex(hrefRegex)
        if (caption != null) {
            return try {
                regex.find(caption)!!.groups[2]!!.value
            } catch (e: Exception) {
                ""
            }
        }
        return ""
    }
}