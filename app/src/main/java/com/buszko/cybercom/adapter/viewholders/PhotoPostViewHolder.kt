package com.buszko.cybercom.adapter.viewholders

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.ImageView
import com.buszko.cybercom.R
import com.buszko.cybercom.viewmodels.postviewmodel.BasePostViewModel
import com.buszko.cybercom.viewmodels.postviewmodel.PhotoPostViewModel
import com.squareup.picasso.Picasso

class PhotoPostViewHolder(itemView: View) : BasePostViewHolder(itemView) {
    val image = itemView.findViewById<ImageView>(R.id.image_view)

    override fun bind(post: BasePostViewModel) {
        post as PhotoPostViewModel

        Picasso.get()
            .load(post.photoUrl)
            .placeholder(R.drawable.placeholder)
            .fit()
            .centerCrop()
            .into(image)
        image.setOnClickListener {
            try {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(post.contentUtl))
                itemView.context.startActivity(browserIntent)
            } catch (e: ActivityNotFoundException) {
                //do nothing
            }
        }
    }
}