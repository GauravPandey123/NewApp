package com.loc.newsapp.domain.repository

import androidx.paging.PagingData
import com.loc.newsapp.data.remote.NewsPagingSource
import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.domain.model.Source
import com.loc.newsapp.prensentation.search.SearchEvent
import kotlinx.coroutines.flow.Flow

interface NewRepository {

    fun getNews(source: List<String>) : Flow<PagingData<Article>>
    fun searchNews(searchQuery:String, source: List<String>) : Flow<PagingData<Article>>
}