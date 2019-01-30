package com.buszko.cybercom.network

import com.buszko.cybercom.model.TumblrResult
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import retrofit2.http.Query


interface TumblrService {

    @GET("read")
    fun getPosts(@Query("start") start: Int, @Query("num") pageSize: Int): Call<TumblrResult>

    companion object {
        fun create(login: String): TumblrService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://$login.tumblr.com/api/")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build()

            return retrofit.create(TumblrService::class.java)
        }
    }
}