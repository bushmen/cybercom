package com.buszko.cybercom.adapter.viewholders

import android.content.Intent
import android.net.Uri
import android.view.View
import com.buszko.cybercom.viewmodels.postviewmodel.BasePostViewModel
import com.buszko.cybercom.viewmodels.postviewmodel.VideoPostViewModel


class VideoPostViewHolder(itemView: View) : BasePostViewHolder(itemView) {
    override fun bind(post: BasePostViewModel) {
        post as VideoPostViewModel

        itemView.setOnClickListener {
            val webIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(post.videoUrl)
            )
            itemView.context.startActivity(webIntent)
        }
    }
}