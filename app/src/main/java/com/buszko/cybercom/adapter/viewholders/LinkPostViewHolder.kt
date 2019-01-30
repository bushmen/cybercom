package com.buszko.cybercom.adapter.viewholders

import android.view.View
import android.widget.TextView
import com.buszko.cybercom.R
import com.buszko.cybercom.viewmodels.postviewmodel.BasePostViewModel
import com.buszko.cybercom.viewmodels.postviewmodel.LinkPostViewModel
import android.content.Intent
import android.net.Uri


class LinkPostViewHolder(itemView: View) : BasePostViewHolder(itemView) {
    private val linkText = itemView.findViewById<TextView>(R.id.link_text)

    override fun bind(post: BasePostViewModel) {
        post as LinkPostViewModel

        linkText.text = post.linkText
        itemView.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(post.linkUrl))
            itemView.context.startActivity(browserIntent)
        }
    }
}