package com.loc.newsapp.domain.usecases.news

import androidx.paging.PagingData
import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.domain.repository.NewRepository
import kotlinx.coroutines.flow.Flow

class GetNews(private val newsRepository: NewRepository) {

    operator fun invoke(source: List<String>) : Flow<PagingData<Article>> {
      return newsRepository.getNews(source = source)
    }
}