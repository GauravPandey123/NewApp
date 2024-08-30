package com.loc.newsapp.data.remote.dto

import com.loc.newsapp.data.remote.NewsResponse
import com.loc.newsapp.utils.Constants.Api_Key
import retrofit2.http.GET
import retrofit2.http.Query

interface NewApi {

    @GET("everyThing")
    suspend fun getNews(
        @Query("page") page: Int,
        @Query("sources") string: String,
        @Query("page") apiKey: String = Api_Key) : NewsResponse

    @GET("everything")
    suspend fun searchNews(
        @Query("q") searchQuery: String,
        @Query("sources") sources: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String = Api_Key
    ): NewsResponse
}