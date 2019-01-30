package com.buszko.cybercom.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.buszko.cybercom.viewmodels.LoginViewModel
import com.buszko.cybercom.R
import com.buszko.cybercom.adapter.PostsAdapter
import com.buszko.cybercom.model.TumblrPost
import com.buszko.cybercom.viewmodels.postviewmodel.BasePostViewModel

class TumblrPostsFragment : Fragment(), PostsAdapter.Listener {
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var postsRecyclerView: RecyclerView
    private lateinit var postsAdapter: PostsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.tumblr_posts_fragment, container, false)

        postsRecyclerView = view.findViewById(R.id.recycler_view)
        postsRecyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        postsAdapter = PostsAdapter(ArrayList(), this@TumblrPostsFragment, context!!)
        postsRecyclerView.adapter = postsAdapter

        loginViewModel.getPostsViewModels().observe(this, object : Observer<List<BasePostViewModel>> {
            override fun onChanged(posts: List<BasePostViewModel>?) {
                postsAdapter.updateItems(posts!!)
            }
        })

        activity?.title = loginViewModel.getLogin().value

        return view
    }

    override fun loadMore() {
        loginViewModel.loadMore()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        loginViewModel = ViewModelProviders.of(activity!!).get(LoginViewModel::class.java)
    }
}