package com.buszko.cybercom.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView.Adapter
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.buszko.cybercom.model.TumblrPost
import com.buszko.cybercom.R
import com.buszko.cybercom.adapter.viewholders.*
import com.buszko.cybercom.model.PostType
import com.buszko.cybercom.pageSize
import com.buszko.cybercom.viewmodels.postviewmodel.BasePostViewModel
import com.buszko.cybercom.viewmodels.postviewmodel.LoadingPostViewModel

class PostsAdapter(var posts: ArrayList<BasePostViewModel>, val listener: Listener, val context: Context) :
    Adapter<BasePostViewHolder>() {

    private var hasMore: Boolean = true

    private val loadingViewModel: LoadingPostViewModel

    init {
        val post = TumblrPost()
        post.type = PostType.loading
        loadingViewModel = LoadingPostViewModel(post)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasePostViewHolder {
        val view = LayoutInflater.from(context).inflate(viewType, parent, false)
        return when (viewType) {
            R.layout.loader -> LoadingViewHolder(view)
            R.layout.photo_post_item -> PhotoPostViewHolder(view)
            R.layout.link_post_item -> LinkPostViewHolder(view)
            R.layout.video_post_item -> VideoPostViewHolder(view)
            R.layout.quote_post_item -> QuotePostViewHolder(view)
            else -> LoadingViewHolder(view)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return posts[position].getLayoutId()
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(viewHolder: BasePostViewHolder, position: Int) {
            viewHolder.bind(posts[position])

            if (hasMore && position == itemCount - 1) {
                listener.loadMore()
            }
    }

    fun updateItems(items: List<BasePostViewModel>) {
        posts.remove(loadingViewModel)

        posts.addAll(items)

        if (items.size == pageSize) {
            posts.add(loadingViewModel)
        } else {
            hasMore = false
        }
        notifyDataSetChanged()
    }

    interface Listener {
        fun loadMore()
    }
}



