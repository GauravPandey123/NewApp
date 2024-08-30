package com.loc.newsapp.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.loc.newsapp.data.remote.dto.NewApi
import com.loc.newsapp.domain.model.Article

class NewsPagingSource(
    private val newsApi: NewApi,
    private val source: String
) : PagingSource<Int,Article>() {

    private var totalNewCount =0

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?: 1
        return try {
           val  newsResponse = newsApi.getNews(page,source)

            totalNewCount += newsResponse.articles.size
            val article = newsResponse.articles.distinctBy { it.title }
            LoadResult.Page(
                data = article,
                nextKey = if (totalNewCount == newsResponse.totalResults) null else page + 1,
                prevKey = null
            )
        }catch (e: Exception){
            e.printStackTrace()
            LoadResult.Error(throwable = e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let {anchorPosition->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1)?:anchorPage?.nextKey?.minus(1)
        }
    }

}