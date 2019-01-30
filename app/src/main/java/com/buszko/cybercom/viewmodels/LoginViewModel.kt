package com.buszko.cybercom.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.buszko.cybercom.converter.TumblrPostConverter
import com.buszko.cybercom.model.TumblrPost
import com.buszko.cybercom.model.TumblrResult
import com.buszko.cybercom.network.TumblrService
import com.buszko.cybercom.pageSize
import com.buszko.cybercom.viewmodels.postviewmodel.BasePostViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {
    private var tumblrService: TumblrService? = null

    private lateinit var login : MutableLiveData<String>
    private var posts : ArrayList<TumblrPost> = ArrayList()
    private var postsViewModels : MutableLiveData<List<BasePostViewModel>>? = null

    private fun getTumblrService(): TumblrService {
        if (tumblrService == null) {
            tumblrService = TumblrService.create(getLogin().value!!)
        }
        return tumblrService!!
    }

    fun clear() {
        tumblrService = null
        postsViewModels = null
        posts = ArrayList()
    }

    fun getLogin() : LiveData<String> {
        if (!::login.isInitialized) {
            login = MutableLiveData()
        }
        return login
    }

    fun setLogin(value: String) {
        if (!::login.isInitialized) {
            login = MutableLiveData()
        }

        login.value = value
    }

    fun getPostsViewModels() : LiveData<List<BasePostViewModel>> {
        if (postsViewModels == null) {
            postsViewModels = MutableLiveData()
            loadPosts()
        }
        return postsViewModels!!
    }

    fun loadMore() {
        loadPosts(posts.size)
    }

    private fun loadPosts(start: Int = 0) {
        getTumblrService().getPosts(start, pageSize).enqueue(object: Callback<TumblrResult> {
            override fun onResponse(call: Call<TumblrResult>, response: Response<TumblrResult>) {
                val elements = response.body()?.posts!!
                posts.addAll(elements)
                postsViewModels!!.postValue(TumblrPostConverter.convert(elements))
            }

            override fun onFailure(call: Call<TumblrResult>, t: Throwable) {
                Log.d("TAGG", t.message)
            }
        })
    }
}